/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ClienteModel;

/**
 *
 * @author Bond
 */
public class ClienteController {
    
    public static final String ATIVO = "Ativo";
    public static final String INATIVO = "Inativo";
    
    public static String getAtividade(ClienteModel c){
        if (c.isAtividade() == true) {
            return ATIVO;
        }
        return INATIVO;
    }
}
