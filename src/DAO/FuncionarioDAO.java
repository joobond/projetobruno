/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CategoriaModel;
import Model.FuncionarioModel;
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
public class FuncionarioDAO {
     public void inserir(FuncionarioModel f){
        try {
            String sql = "INSERT INTO funcionarios (nome_completo,data_nascimento,cpf,telefone,salario,email,senha) "
                    + "VALUES (?,?,?,?,?,?,?)";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, f.getNome_completo());
            stmt.setString(2, f.getData_nascimento());
            stmt.setString(3, f.getCpf());
            stmt.setInt(4, f.getTelefone());
            stmt.setFloat(5, f.getSalario());
            stmt.setString(6, f.getEmail());
            stmt.setString(7, f.getSenha());
            
            stmt.execute();
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao cadastrar funcionário.");
        }
    }
    
    public ArrayList<FuncionarioModel> obterTodos(){
        try {
            String sql = "SELECT * FROM funcionarios";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            return montaFuncionario(rs);
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar funcionários.");
            return null;
        }
    }
    
    public FuncionarioModel obterPorPK(int pk){
        try {
            String sql = "SELECT * FROM funcionarios WHERE id = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pk);
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<FuncionarioModel> array = montaFuncionario(rs);
            
            if (array.size()>0) {
                return array.get(0);
            }else{
                return null;
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar o funcionario número "+pk);
            return null;
        }
    }
    
    public boolean excluir(int pk){
        try {
            String sql = "DELETE FROM funcionarios WHERE id = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pk);
            int ret = stmt.executeUpdate();
            return ret != 0;
        } catch (SQLException ex){
            ex.getStackTrace();
            System.out.println("Erro ao apagar o funcionário número "+pk);
            return false;
        }
    }
    
    //Sobrecarga de Método
    public boolean excluir(FuncionarioModel f){
        return this.excluir(f.getId());
    }
    
    public ArrayList<FuncionarioModel> montaFuncionario(ResultSet rs) throws SQLException{
        ArrayList<FuncionarioModel> retorno = new ArrayList();
        while (rs.next()) {
            FuncionarioModel f = new FuncionarioModel();
            f.setId(rs.getInt("id"));
            f.setNome_completo(rs.getString("nome_completo"));
            f.setCpf(rs.getString("cpf"));
            f.setSalario(rs.getFloat("salario"));
            f.setData_nascimento(rs.getString("data_nascimento"));
            f.setTelefone(rs.getInt("telefone"));
            f.setEmail(rs.getString("email"));
            f.setSenha(rs.getString("senha"));
            retorno.add(f);
        }
        return retorno;
    }
    
    public void atualizar(FuncionarioModel f) {
       String sql = "UPDATE categorias SET nome_completo=?,data_nascimento=?,cpf=?,telefone=?,salario=?,email=?,senha=? WHERE id=?";

       try {
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, f.getNome_completo());
            stmt.setString(2, f.getData_nascimento());
            stmt.setString(3, f.getCpf());
            stmt.setInt(4, f.getTelefone());
            stmt.setFloat(5, f.getSalario());
            stmt.setString(6, f.getEmail());
            stmt.setString(7, f.getSenha());
            stmt.setInt(8, f.getId());
            
            stmt.execute();
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao atualizar funcionário.");
        }
    }
}
