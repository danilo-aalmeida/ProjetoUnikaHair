/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fean.si.poo2.projetounikahair.services;

import br.com.fean.si.poo2.projetounikahair.dao.CategoriaCursoDao;
import br.com.fean.si.poo2.projetounikahair.model.CategoriaCurso;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class CategoriaCursoService {

    CategoriaCursoDao categoriaCursoDao = new CategoriaCursoDao();

    public String inserir(String nomeCC, String descricao) {
        CategoriaCurso cc = new CategoriaCurso(nomeCC,descricao);
      

        String retorno = categoriaCursoDao.inserir(cc);
       
        return retorno;
    }

    public String editar(int id, String nomeCC, String descricao) {

        CategoriaCurso cc = new CategoriaCurso(id, nomeCC, descricao);

        cc.setId(id);
        cc.setNomeCC(nomeCC);
        cc.setDescricao(descricao);

        String retorno = categoriaCursoDao.editar(cc);
      
        return retorno;
    }

    public String apagar(int id) {
        CategoriaCurso cc = new CategoriaCurso(id);

        String retorno = categoriaCursoDao.excluir(cc);
       
        return retorno;
    }

    public ArrayList<CategoriaCurso> listar(String palavraChave) {
        ArrayList<CategoriaCurso> lista = categoriaCursoDao.listar(palavraChave);
        
        return lista;
    }

}
