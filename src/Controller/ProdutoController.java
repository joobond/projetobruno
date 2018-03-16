/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ProdutoModel;

/**
 *
 * @author Bond
 */
public class ProdutoController {
    public static final String ATIVO = "Ativo";
    public static final String INATIVO = "Inativo";
    
    public static String getAtividade(ProdutoModel p){
        if (p.isAtividade() == true) {
            return ATIVO;
        }
        return INATIVO;
    }
  
}
