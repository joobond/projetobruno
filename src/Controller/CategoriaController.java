/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CategoriaModel;

/**
 *
 * @author Bond
 */
public class CategoriaController{
    public static final String ATIVO = "Ativa";
    public static final String INATIVO = "Inativa";
    
    public static String getAtividade(CategoriaModel c){
        if (c.isAtividade() == true) {
            return ATIVO;
        }
        return INATIVO;
    }
}
