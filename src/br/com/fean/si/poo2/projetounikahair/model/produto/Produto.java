package br.com.fean.si.poo2.projetounikahair.model.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name ="COD_PRODUTO")
	private Integer codigoProduto;
	
	@Column(name = "NOME_PRODUTO")
	private String nomeProduto;
	
	@Column(name = "PRECO_VENDA")
	private Double precoVenda;
	
	@Column(name = "ESTOQUE_MINIMO")
	private Integer estoqueMinimo;
	
	@Column(name = "QUANTIDADE_ESTOQUE")
	private Integer quantidadeEstoque;
	
	@Column(name = "MARCA")
	private String marca;
	
	@Column(name = "CATEGORIA_PRODUTO")
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
