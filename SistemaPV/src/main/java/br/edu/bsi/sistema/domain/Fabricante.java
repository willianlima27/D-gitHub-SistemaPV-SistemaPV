package br.edu.bsi.sistema.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Fabricante extends GenericDomain{
	
	//Define que o atributo será uma coluna no banco de dados do tipo varchar de tamanho 100
	@Column(length = 100, nullable = false)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
