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
    private CategoriaModel categoria;
    private int quantidade;
    private float valor;
    private boolean atividade;
    
    private int idCategoria;
    private int idReceita;
    private int idFuncionario;

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

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
    @Override
    public String toString(){
        return "ID: "+this.getId()+" \nDescrição: "+this.getDescricao()+" \nCategoria: "+this.getCategoria().getNome()+" "
                + "\nQuantidade: "+this.getQuantidade()+" \nValor: R$ "+this.getValor()+" "
                + "\nAtividade: "+ProdutoController.getAtividade(this);
    }
   
}
