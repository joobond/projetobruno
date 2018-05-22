/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ReceitaDAO;
import Model.IngredienteModel;
import Model.ReceitaModel;
import java.util.ArrayList;

/**
 *
 * @author Bond
 */
public class ReceitaController {
    private ReceitaDAO dao;
    
    public ReceitaController() {
        this.dao = new ReceitaDAO();
    }
    
    public boolean addReceita(String nome, ArrayList<IngredienteModel> ingredientes) {
        ReceitaModel receita = new ReceitaModel();
        
        receita.setNome(nome);
        receita.setIngredientes(ingredientes);
        
        if(this.dao.inserir(receita))
            return true;
        
        return false;
    }
}
