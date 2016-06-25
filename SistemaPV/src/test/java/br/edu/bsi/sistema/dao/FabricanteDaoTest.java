package br.edu.bsi.sistema.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.bsi.sistema.domain.Fabricante;

public class FabricanteDaoTest {
	
	@Test
	//@Ignore
	public void salvar(){
		
		//Cria o objeto que ira receber os dados
		Fabricante fabricante = new Fabricante();
		
		//Preenche os atributos do objeto
		fabricante.setDescricao(null);
		
		//Cria o objeto que permite chamar ações do banco de dados
		FabricanteDAO fdao = new FabricanteDAO();
		
		//Invoca a operação de salvar
		fdao.salvar(fabricante);
	}
	
	@Test
	@Ignore
	public void listar(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		//Lista que recebe os resultados do método
		List<Fabricante> resultado = fabricanteDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		//foreach par apercorrer a lista
		for(Fabricante fabricante : resultado){
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 4L;
		
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		//acecssar o método buscar e passar o parametro codigo
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encotrado:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 6L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		//Primeiro deve-se buscar o elemento a excluir
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			fabricanteDAO.excluir(fabricante);
			System.out.println("Registro removido:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 5L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		System.out.println("Fabricante a ser editado:");
		System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		
		fabricante.setDescricao("Fabricante Alterado");
		
		fabricanteDAO.editar(fabricante);
		
		System.out.println("Fabricante Editado:");
		System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		
	}

}
