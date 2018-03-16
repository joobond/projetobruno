/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.CategoriaController;

/**
 *
 * @author Bond
 */
public class CategoriaModel {
    private int id;
    private String nome;
    public boolean atividade;

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

    public boolean isAtividade() {
        return atividade;
    }

    public void setAtividade(boolean atividade) {
        this.atividade = atividade;
    }
    
    @Override
    public String toString(){
        return "ID: "+this.getId()+" \nNome: "+this.getNome()+" "
                + "\nAtividade: "+CategoriaController.getAtividade(this);
    }
}
