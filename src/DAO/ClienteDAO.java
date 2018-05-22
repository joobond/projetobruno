/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ClienteModel;
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
public class ClienteDAO {
    public void inserir(ClienteModel c){
        try {
            String sql = "INSERT INTO clientes (nome_completo,cpf,data_nascimento,pontos,atividade,telefone) "
                    + "VALUES (?,?,?,?,?,?)";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, c.getNome_completo());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getData_nascimento());
            stmt.setInt(4, c.getPontos());
            stmt.setBoolean(5, c.isAtividade());
            stmt.setInt(6, c.getTelefone());
            
            stmt.execute();
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao cadastrar cliente.");
        }
    }
    
    public ArrayList<ClienteModel> obterTodos(){
        try {
            String sql = "SELECT * FROM clientes";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            return montaCliente(rs);
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar clientes.");
            return null;
        }
    }
    
    public ClienteModel obterPorPK(int pk){
        try {
            String sql = "SELECT * FROM clientes WHERE id = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pk);
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<ClienteModel> array = montaCliente(rs);
            
            if (array.size()>0) {
                return array.get(0);
            }else{
                return null;
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar o cliente número "+pk);
            return null;
        }
    }
    
    public boolean inativar(int pk){
        try {
            String sql = " UPDATE clientes SET atividade=0 WHERE id = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pk);
            int ret = stmt.executeUpdate();
            return ret != 0;
        } catch (SQLException ex){
            ex.getStackTrace();
            System.out.println("Erro ao inativar o cliente número "+pk);
            return false;
        }
    }
    
    //Sobrecarga de Método
    public boolean inativar(ClienteModel c){
        return this.inativar(c.getId());
    }
    
    public ArrayList<ClienteModel> montaCliente(ResultSet rs) throws SQLException{
        ArrayList<ClienteModel> retorno = new ArrayList();
        while (rs.next()) {
            ClienteModel c = new ClienteModel();
            c.setId(rs.getInt("id"));
            c.setNome_completo(rs.getString("nome_completo"));
            c.setCpf(rs.getString("cpf"));
            c.setPontos(rs.getInt("pontos"));
            c.setData_nascimento(rs.getString("data_nascimento"));
            c.setAtividade(rs.getBoolean("atividade"));
            c.setTelefone(rs.getInt("telefone"));
            retorno.add(c);
        }
        return retorno;
    }
    public void atualizar(ClienteModel c) {
       String sql = "UPDATE clientes SET nome_completo=?,data_nascimento=?,pontos=?,atividade=?,telefone=? WHERE id=?";

       try {
          Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, c.getNome_completo());
            stmt.setString(2, c.getData_nascimento());
            stmt.setInt(3, c.getPontos());
            stmt.setBoolean(4, c.isAtividade());
            stmt.setInt(5, c.getTelefone());
            stmt.setInt(6, c.getId());
            
            stmt.execute();
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao atualizar cliente.");
        }
   }
}
