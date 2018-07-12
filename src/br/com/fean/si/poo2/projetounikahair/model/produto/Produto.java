package br.com.fean.si.poo2.projetounikahair.model.produto;

public class Produto {
	
	private Integer codigoProduto;
	private String nomeProduto;
	private Double precoVenda;
	private Integer estoqueMinimo;
	private Integer quantidadeEstoque;
	private String marca;
	private String categoriaProduto;
	
	
	public Produto(Integer codigoProduto, String nomeProduto, Double precoVenda, Integer estoqueMinimo,
			Integer quantidadeEstoque, String marca, String categoriaProduto) {
	
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.precoVenda = precoVenda;
		this.estoqueMinimo = estoqueMinimo;
		this.quantidadeEstoque = quantidadeEstoque;
		this.marca = marca;
		this.categoriaProduto = categoriaProduto;
	}
	
	public Integer getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public Integer getEstoqueMinimo() {
		return estoqueMinimo;
	}
	public void setEstoqueMinimo(Integer estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCategoriaProduto() {
		return categoriaProduto;
	}
	public void setCategoriaProduto(String categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}
	
	
	
	

}
