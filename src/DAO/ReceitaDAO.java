/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.IngredienteModel;
import Model.ReceitaModel;
import Util.conexãoSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ecles
 */
public class ReceitaDAO {

    public boolean inserir(ReceitaModel receita) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO receitas (nome) VALUES (?)";

            conn = conexãoSingleton.getConnection();
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, receita.getNome());

            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            int id_receita = 0;

            while (rs.next()) {
                id_receita = rs.getInt(1);
            }
            this.vincularReceitaProduto(id_receita, receita.getIngredientes());
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar receita " + e);

            return false;
        }
    }

    public void vincularReceitaProduto(int id_receita, ArrayList<IngredienteModel> ingredientes) {
        PreparedStatement stmt = null;
        for (IngredienteModel i : ingredientes) {
            try {
                String sql = "INSERT INTO receitaingredientes (id_receita, id_ingrediente, quantidade) VALUES (?, ?, ?)";
                stmt = conexãoSingleton.getConnection().prepareStatement(sql);
                stmt.setInt(1, id_receita);
                stmt.setInt(2, i.getId());
                stmt.setFloat(3, i.getQuantidade());

                stmt.execute();
            } catch (SQLException e) {
                System.out.println("Erro ao vincular ingrediente na receita " + e);
            }
        }
    }

    public ArrayList<ReceitaModel> obterTodos() {
        try {
            String sql = "SELECT * FROM receitas";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            return montaReceita(rs);
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar receitas.");
            return null;
        }
    }

    public int obterPK(String nome) {
        int pk = 0;
        try {
            String sql = "SELECT id FROM receitas where nome = ?";
            Connection conn = conexãoSingleton.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pk = rs.getInt("id");
            }
            return pk;
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Erro ao buscar receitas.");
            return pk;
        }
    }

    private ArrayList<ReceitaModel> montaReceita(ResultSet rs) throws SQLException {
        ArrayList<ReceitaModel> retorno = new ArrayList();
        while (rs.next()) {
            ReceitaModel r = new ReceitaModel();
            r.setId(rs.getInt("id"));
            r.setNome(rs.getString("nome"));
            retorno.add(r);
        }
        return retorno;
    }
}
