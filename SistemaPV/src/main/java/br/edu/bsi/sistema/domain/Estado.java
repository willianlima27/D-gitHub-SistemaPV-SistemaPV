package br.edu.bsi.sistema.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Estado extends GenericDomain{
	
	//Define que o atributo será uma coluna no banco de dados de tamanho 2 e não aceita valor nulo
	@Column(length = 2, nullable = false)
	//indica que o atributo não é opcional, ou seja, é obrigatório (na aplicação, sem acessar o banco)
	@Basic(optional = false)
	private String sigla;
	
	@Column(length = 50, nullable = false)
	@Basic(optional = false)
	private String nome;
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
