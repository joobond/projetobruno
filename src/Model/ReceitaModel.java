/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Bond
 */
public class ReceitaModel {
    private int id;
    private String nome;
    private ArrayList<IngredienteModel> ingredientes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<IngredienteModel> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<IngredienteModel> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    
}
