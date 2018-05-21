/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.IngredienteDAO;
import Model.IngredienteModel;
import java.util.ArrayList;

/**
 *
 * @author ecles
 */
public class IngredienteController {
    
    public ArrayList<IngredienteModel> buscarIngredientes() {
        IngredienteDAO dao = new IngredienteDAO();
        return dao.obterTodos();
    }
    
    public IngredienteModel findIngrediente(String ingrediente) {
        int fim = ingrediente.indexOf(")");
        int id = Integer.parseInt(ingrediente.substring(0, fim).replace("(", ""));
        
        IngredienteDAO dao = new IngredienteDAO();
        return dao.obterPorPK(id);
    }
}
