package br.com.fean.si.poo2.projetounikahair.model;

import java.io.Serializable;

/**
 * @author joao(jhveppo@gmail.com)
 *
 */
public abstract class AbstractEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    public abstract Integer getId();
}
