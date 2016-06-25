package br.edu.bsi.sistema.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
//define que a classe será uma tabela no banco de dados
@Entity
public class Produto extends GenericDomain{
	
	@Column(length = 80, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private short quantidade;
	
	//Precision - define a precisão de algarismos do preco, scala - casas decimais
	//bigdecimal, - uso profissional de valores com virgulas
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal preco;
	
	//cardinalidade
	@ManyToOne
	//A coluna não pode ser nula
	@JoinColumn(nullable = false)
	private Fabricante fabricante;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public short getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(short quantidade) {
		this.quantidade = quantidade;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
}
