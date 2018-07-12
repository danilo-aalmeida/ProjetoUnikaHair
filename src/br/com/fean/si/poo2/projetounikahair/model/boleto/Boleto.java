package br.com.fean.si.poo2.projetounikahair.model.boleto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "boleto")
public class Boleto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "COD_BANCO")
	private Integer codigoBanco;
	
	@Column(name = "NOME_BANCO")
	private String nomeBanco;
	
	@Column(name = "NUMERO_CONTA")
	private Integer numeroConta;
	
	@Column(name = "MENSAGEM_CLIENTE")
	private String mensagemCliente;
	
	
	public Boleto(Integer codigoBanco, String nomeBanco, Integer numeroConta, String mensagemCliente) {
		this.codigoBanco = codigoBanco;
		this.nomeBanco = nomeBanco;
		this.numeroConta = numeroConta;
		this.mensagemCliente = mensagemCliente;
	}
	
	public Integer getCodigoBanco() {
		return codigoBanco;
	}
	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}
	public Integer getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getMensagemCliente() {
		return mensagemCliente;
	}
	public void setMensagemCliente(String mensagemCliente) {
		this.mensagemCliente = mensagemCliente;
	}
	public String getNomeBanco() {
		return nomeBanco;
	}
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
}
