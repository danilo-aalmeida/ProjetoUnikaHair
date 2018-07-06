/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fean.si.poo2.projetounikahair.model;

import java.math.BigInteger;

/**
 *
 * @author Lucas
 */
public class CategoriaCurso {
    
    private int id;
    private String nomeCC;
    private String descricao;
    
    public CategoriaCurso(String nomeCC, String descricao) {
        this.nomeCC = nomeCC;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCC() {
        return nomeCC;
    }

    public void setNomeCC(String nomeCC) {
        this.nomeCC = nomeCC;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public CategoriaCurso(int id, String nomeCC, String descricao) {
        this.id = id;
        this.nomeCC = nomeCC;
        this.descricao = descricao;
    }
    
     public CategoriaCurso(int id) {
        this.id = id;
        
    }
    
    
}
