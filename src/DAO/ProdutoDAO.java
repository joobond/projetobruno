/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CategoriaModel;
import Model.ProdutoModel;
import Util.conexãoSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bond
 */
public class ProdutoDAO {
    public void inserir(ProdutoModel p){
        try {
            String sql = "INSERT INTO produtos"
                    + " (descricao,id_categoria,quantidade,valor,atividade)"
                    + "VALUES (?,?,?,?,?)";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getCategoria().getId());
            stmt.setInt(3, p.getQuantidade());
            stmt.setFloat(4, p.getValor());
            stmt.setBoolean(5, p.isAtividade());
            
            stmt.execute();
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao cadastrar produto.");
        }
    }
    
    public void adicionarReceita(int id_receita) {
        try {
            String sql = "UPDATE produtos SET id_receita = ?";
            
            PreparedStatement stmt = conexãoSingleton.getConnection().prepareStatement(sql);
            stmt.setInt(1, id_receita);
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar uma receita ao produto");
        }
    }
    
    public ArrayList<ProdutoModel> obterTodos(){
        try {
            String sql = "SELECT * "
                    + "FROM produtos "
                    + "INNER JOIN categorias "
                    + "ON categorias.id = produtos.id_categoria";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            return montaProduto(rs);
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar produtos.");
            return null;
        }
    }
    
    public ProdutoModel obterPorPK(int pk){
        try {
            String sql ="SELECT * "
                    + "FROM produtos "
                    + "INNER JOIN categorias "
                    + "ON categorias.id = produtos.id_categoria "
                    + "WHERE id = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pk);
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<ProdutoModel> array = montaProduto(rs);
            
            if (array.size()>0) {
                return array.get(0);
            }else{
                return null;
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar o produto número "+pk);
            return null;
        }
    }
    
    public boolean inativar(int pk){
        try {
            String sql = "UPDATE produtos SET atividade = 0 WHERE id = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pk);
            int ret = stmt.executeUpdate();
            return ret != 0;
        } catch (SQLException ex){
            ex.getStackTrace();
            System.out.println("Erro ao inativar o produto número "+pk);
            return false;
        }
    }
    
    //Sobrecarga de Método
    public boolean inativar(ProdutoModel p){
        return this.inativar(p.getId());
    }
    
    public ArrayList<ProdutoModel> montaProduto(ResultSet rs) throws SQLException{
        ArrayList<ProdutoModel> retorno = new ArrayList();
        while (rs.next()) {
            ProdutoModel p = new ProdutoModel();
            CategoriaModel c = new CategoriaModel();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            p.setId(rs.getInt("id"));
            p.setDescricao(rs.getString("descricao"));
            p.setCategoria(c);
            p.setQuantidade(rs.getInt("quantidade"));
            p.setValor(rs.getFloat("valor"));
            p.setAtividade(rs.getBoolean("atividade"));
            retorno.add(p);
        }
        return retorno;
    }
}
