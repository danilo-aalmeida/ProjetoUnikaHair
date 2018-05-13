package br.com.fean.si.poo2.projetounikahair.model.boleto;

public class Boleto {
	
	private Integer codigoBanco;
	private String nomeBanco;
	private Integer numeroConta;
	private String mensagemCliente;
	
	
	public Boleto(Integer codigoBanco2, String nomeBanco2, Integer numeroConta2, String mensagemCliente2) {
		

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
