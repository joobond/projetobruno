/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.IngredienteModel;
import Util.conexãoSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bond
 */
public class IngredienteDAO {
    
    public void inserir(IngredienteModel i){
        try {
            String sql = "INSERT INTO ingredientes (nome,quantidade,data_ultima_compra,valor_ultima_compra) "
                    + "VALUES (?,?,?,?)";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, i.getNome());
            stmt.setFloat(2, i.getQuantidade());
            stmt.setString(3,i.getData_ultima_compra());
            stmt.setFloat(4, i.getValor_ultima_compra());
            
            stmt.execute();
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao cadastrar ingrediente.");
        }
    }
    
    public ArrayList<IngredienteModel> obterTodos(){
        try {
            String sql = "SELECT * FROM ingredientes";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            return montaIngrediente(rs);
            
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar ingredientes.");
            return null;
        }
    }
    
    public IngredienteModel obterPorPK(int pk){
        try {
            String sql = "SELECT * FROM ingredientes WHERE id = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pk);
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<IngredienteModel> array = montaIngrediente(rs);
            
            if (array.size()>0) {
                return array.get(0);
            }else{
                return null;
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar o ingrediente número "+pk);
            return null;
        }
    }
    
    public boolean excluir(int pk){
        try {
            String sql = "DELETE FROM ingredientes WHERE id = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pk);
            int ret = stmt.executeUpdate();
            return ret != 0;
        } catch (SQLException ex){
            ex.getStackTrace();
            System.out.println("Erro ao apagar o ingrediente número "+pk);
            return false;
        }
    }
    
    //Sobrecarga de Método
    public boolean excluir(IngredienteModel i){
        return this.excluir(i.getId());
    }
    
    public ArrayList<IngredienteModel> montaIngrediente(ResultSet rs) throws SQLException{
        ArrayList<IngredienteModel> retorno = new ArrayList();
        while (rs.next()) {
            IngredienteModel i = new IngredienteModel();
            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("descricao"));
            i.setQuantidade(rs.getFloat("quantidade"));
            i.setData_ultima_compra(rs.getString("data_ultima_compra"));
            i.setValor_ultima_compra(rs.getFloat("valor_ultima_compra"));
            retorno.add(i);
        }
        return retorno;
    }
}
