package br.edu.bsi.sistema.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.bsi.sistema.domain.Estado;

public class EstadoDaoTest {
	
	@Test
	@Ignore
	 //ignora o registro ja existente e avança
	public void salvar(){
		
		//Cria o objeto que ira receber os dados
		Estado estado = new Estado();
		
		//Preenche os atributos do objeto
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");
		
		//Cria o objeto que permite chamar ações do banco de dados
		EstadoDAO edao = new EstadoDAO();
		
		//Invoca a operação de salvar
		edao.salvar(estado);
	}
	
	@Test
	@Ignore
	public void listar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		//Lista que recebe os resultados do método
		List<Estado> resultado = estadoDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		//foreach par apercorrer a lista
		for(Estado estado : resultado){
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		//acecssar o método buscar e passar o parametro codigo
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encotrado:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 5L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		//Primeiro deve-se buscar o elemento a excluir
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			estadoDAO.excluir(estado);
			System.out.println("Registro removido:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 4L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		System.out.println("Estado a ser editado:");
		System.out.println("Código do Estado: " + estado.getCodigo());
		System.out.println("Sigla do Estado: " + estado.getSigla());
		System.out.println("Nome do Estado: " + estado.getNome());
		
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");
		
		estadoDAO.editar(estado);
		
		System.out.println("Estado Editado:");
		System.out.println("Código do Estado: " + estado.getCodigo());
		System.out.println("Sigla do Estado: " + estado.getSigla());
		System.out.println("Nome do Estado: " + estado.getNome());
		
	}

}
