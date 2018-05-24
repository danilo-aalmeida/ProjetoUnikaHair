package br.com.fean.si.poo2.projetounikahair.model.exemploVeppo;

import br.com.fean.si.poo2.projetounikahair.model.AbstractEntity;

/**
 * @author joao(jhveppo@gmail.com)
 *
 */
public class Exemplo extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;
	
	private Double valor;

	public Exemplo() {
	}
	
	public Exemplo(Integer codigo, String nome, Double valor) {
		this.id = codigo;
		this.nome = nome;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
