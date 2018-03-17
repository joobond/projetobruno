/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CategoriaModel;
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
public class CategoriaDAO {

    public void inserir(CategoriaModel c) {
        try {
            String sql = "INSERT INTO categorias (nome,atividade) "
                    + "VALUES (?,?)";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, c.getNome());
            stmt.setBoolean(2, c.isAtividade());

            stmt.execute();
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao cadastrar categoria.");
        }
    }

    public ArrayList<CategoriaModel> obterTodos() {
        try {
            String sql = "SELECT * FROM categorias";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            return montaCategoria(rs);
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar categorias.");
            return null;
        }
    }

    public CategoriaModel obterPorPK(int pk) {
        try {
            String sql = "SELECT * FROM categorias WHERE id = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, pk);
            ResultSet rs = stmt.executeQuery();

            ArrayList<CategoriaModel> array = montaCategoria(rs);

            if (array.size() > 0) {
                return array.get(0);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar o categoria número " + pk);
            return null;
        }
    }

    public ArrayList<CategoriaModel> obterPorAtividade(int at) {
        try {
            String sql = "SELECT * FROM categorias where atividade = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, at);
            ResultSet rs = stmt.executeQuery();

            return montaCategoria(rs);
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar categorias.");
            return null;
        }
    }

    public ArrayList<CategoriaModel> obterPorNome(String nome) {
        try {
            String sql = "SELECT * FROM categorias where nome like ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            return montaCategoria(rs);
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar categorias.");
            return null;
        }
    }

    public boolean inativar(int pk) {
        try {
            String sql = "UPDATE categorias SET atividade = 0 WHERE id = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, pk);
            int ret = stmt.executeUpdate();
            return ret != 0;
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao inativar a categoria número " + pk);
            return false;
        }
    }

    //Sobrecarga de Método
    public boolean inativar(CategoriaModel c) {
        return this.inativar(c.getId());
    }

    public ArrayList<CategoriaModel> montaCategoria(ResultSet rs) throws SQLException {
        ArrayList<CategoriaModel> retorno = new ArrayList();
        while (rs.next()) {
            CategoriaModel c = new CategoriaModel();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setAtividade(rs.getBoolean("atividade"));
            retorno.add(c);
        }
        return retorno;
    }
}
