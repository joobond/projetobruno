/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.ClienteController;

/**
 *
 * @author Bond
 */
public class ClienteModel {
    private int id;
    private String nome_completo;
    private String cpf;
    private String data_nascimento;
    private int pontos;
    private boolean atividade;
    private int telefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public boolean isAtividade() {
        return atividade;
    }

    public void setAtividade(boolean atividade) {
        this.atividade = atividade;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString(){
        return "ID: "+this.getId()+" \nNome: "+this.getNome_completo()+" \nData Nascimento: "+this.getData_nascimento()+" \n"
                + "CPF: "+this.getCpf()+" \nPontos: "+this.getPontos()+" pontos \nTelefone: "+this.getTelefone()
                +" \nAtividade: "+ClienteController.getAtividade(this);
    }
}
