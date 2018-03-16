/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.ProdutoController;

/**
 *
 * @author Bond
 */
public class ProdutoModel {
    private int id;
    private String descricao;
    private CategoriaModel id_categoria;
    private int quantidade;
    private float valor;
    private boolean atividade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaModel getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(CategoriaModel id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isAtividade() {
        return atividade;
    }

    public void setAtividade(boolean atividade) {
        this.atividade = atividade;
    }
    
    @Override
    public String toString(){
        return "ID: "+this.getId()+" \nDescrição: "+this.getDescricao()+" \nCategoria: "+this.getId_categoria().getNome()+" "
                + "\nQuantidade: "+this.getQuantidade()+" \nValor: R$ "+this.getValor()+" "
                + "\nAtividade: "+ProdutoController.getAtividade(this);
    }
   
}
