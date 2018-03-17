/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import DAO.CategoriaDAO;
import DAO.ClienteDAO;
import DAO.FuncionarioDAO;
import DAO.IngredienteDAO;
import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import Model.CategoriaModel;
import Model.ClienteModel;
import Model.FuncionarioModel;
import Model.IngredienteModel;
import Model.ProdutoModel;
import Model.UsuarioModel;

/**
 *
 * @author Bond
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        IngredienteModel i = new IngredienteModel();
//        i.setNome("Calabresa");
//        i.setQuantidade(3);
//        i.setData_ultima_compra("14/02/2018");
//        i.setValor_ultima_compra((float) 4.50);
//        
//        IngredienteDAO id = new IngredienteDAO();
//        id.inserir(i);
//        for(IngredienteModel i1 : id.obterTodos()){
//            System.out.println("-- Ingrediente --");
//            System.out.println(i1.toString());
//            System.out.println("----------------------");
//        }
//        IngredienteModel i1 = new IngredienteModel();
//        i1.setId(2);
//        System.out.println(id.excluir(i1.getId()));
//        
//        System.out.println(id.obterPorPK(i1.getId()));
//        ClienteModel c = new ClienteModel();
//        c.setNome_completo("João Bond");
//        c.setCpf("1234567");
//        c.setData_nascimento("01/09/1998");
//        c.setPontos(0);
//        c.setTelefone(992019585);
//        c.setAtividade(true);
//        ClienteDAO cd = new ClienteDAO();
//        cd.inserir(c);
//        c.setId(1);
//        cd.inativar(c);
//        System.out.println(cd.obterPorPK(c.getId()));
//        for(ClienteModel c : cd.obterTodos()){
//            System.out.println(c.toString());
//        }
//        FuncionarioModel f = new FuncionarioModel();
//        f.setNome_completo("Karolayne Braz");
//        f.setCpf("32456");
//        f.setData_nascimento("11/08/2000");
//        f.setTelefone(3245678);
//        f.setSalario(1500);
//        FuncionarioDAO fd = new FuncionarioDAO();
//        fd.inserir(f);
//        f.setId(1);
//        fd.excluir(f);
//        System.out.println(fd.obterPorPK(f.getId()));
//        for(FuncionarioModel f : fd.obterTodos()){
//            System.out.println(f.toString());
//        }
//        CategoriaModel ca = new CategoriaModel();
//        ca.setNome("Assados");
//        ca.setAtividade(true);
//        
//        CategoriaDAO cad = new CategoriaDAO();
        //cad.inserir(ca);
//        for(CategoriaModel cat : cad.obterTodos()){
//            System.out.println(cat.toString());
//        }
//        ProdutoModel p = new ProdutoModel();
//        p.setDescricao("Fanta Laranja 350ml");
//
//        CategoriaModel c = new CategoriaModel();
//        c.setId(2);
//        
//        p.setCategoria(c);
//        p.setQuantidade(2);
//        p.setValor((float)3.50);
//        p.setAtividade(true);
//        
//        ProdutoDAO pd = new ProdutoDAO();
//        pd.inserir(p);
////        
//        for(ProdutoModel pt : pd.obterTodos()){
//            System.out.println("----------------------");
//            System.out.println("-- Produtos --");
//            System.out.println(pt.toString());
//        }
        
        UsuarioModel us = new UsuarioModel();
        us.setId(0);
        us.setUsuario("robson");
        us.setSenha("catuaba");
        
        UsuarioDAO userDAO = new UsuarioDAO();
        userDAO.inserir(us);
/*        for (UsuarioModel usuario : userDAO.obterTodos()) {
            System.out.println(usuario.toString());
        }*/
        

    }

}
