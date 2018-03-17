/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.UsuarioModel;
import Util.conexãoSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class UsuarioDAO {

    public void inserir(UsuarioModel u) {
        try {
            String sql = "INSERT INTO usuarios"
                    + " (usuario,senha)"
                    + "VALUES (?,?)";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getSenha());

            stmt.execute();
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao cadastrar usuario.");
        }
    }

    public ArrayList<UsuarioModel> obterTodos() {
        try {
            String sql = "select * from usuarios;";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            return montaUsuario(rs);
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar usuarios.");
            return null;
        }
    }

    public UsuarioModel obterPorPK(int pk) {
        try {
            String sql = "SELECT * usuarios"
                    + "WHERE id = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, pk);
            ResultSet rs = stmt.executeQuery();

            ArrayList<UsuarioModel> array = montaUsuario(rs);

            if (array.size() > 0) {
                return array.get(0);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar o usuário número " + pk);
            return null;
        }
    }

    public ArrayList<UsuarioModel> montaUsuario(ResultSet rs) throws SQLException {
        ArrayList<UsuarioModel> retorno = new ArrayList();
        while (rs.next()) {
            UsuarioModel u = new UsuarioModel();
            u.setId(rs.getInt("id"));
            u.setUsuario(rs.getString("usuario"));
            u.setSenha(rs.getString("senha"));
            retorno.add(u);
        }
        return retorno;
    }
}
