package br.com.fean.si.poo2.projetounikahair.model.boleto;

public class Boleto {
	
	private Integer codigoBanco;
	private String nomeBanco;
	private Integer numeroConta;
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
