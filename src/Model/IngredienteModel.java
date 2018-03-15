/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Bond
 */
public class IngredienteModel {
    private int id;
    private String nome;
    private float quantidade;
    private String data_ultima_compra;
    private float valor_ultima_compra;

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

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public String getData_ultima_compra() {
        return data_ultima_compra;
    }

    public void setData_ultima_compra(String data_ultima_compra) {
        this.data_ultima_compra = data_ultima_compra;
    }

    public float getValor_ultima_compra() {
        return valor_ultima_compra;
    }

    public void setValor_ultima_compra(float valor_ultima_compra) {
        this.valor_ultima_compra = valor_ultima_compra;
    }
    
    @Override
    public String toString(){
        return "ID: "+this.getId()+" \nNome: "+this.getNome()+" \nQuantidade: "+this.getQuantidade()+" \n"
                + "Data Última Compra: "+this.getData_ultima_compra()+" \nValor Última Compra: R$"+this.getValor_ultima_compra();
    }
}
