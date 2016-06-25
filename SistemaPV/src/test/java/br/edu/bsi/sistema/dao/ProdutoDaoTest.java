package br.edu.bsi.sistema.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.bsi.sistema.domain.Fabricante;
import br.edu.bsi.sistema.domain.Produto;
import br.edu.bsi.sistema.dao.FabricanteDAO;

public class ProdutoDaoTest {
	
	@Test
	public void salvar(){
		
		Long codigoFabricante = 5L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);
		
		//Cria o objeto que ira receber os dados
		Produto produto = new Produto();
		
		//Preenche os atributos do objeto
		produto.setDescricao("Produto 6");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal(29.90));
		produto.setQuantidade((short)7);
		
		//Cria o objeto que permite chamar ações do banco de dados
		ProdutoDAO produtodao = new ProdutoDAO();
		
		//Invoca a operação de salvar
		produtodao.salvar(produto);
	}
	
	@Test
	@Ignore
	public void listar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();
		
		for(Produto produto : resultado){
			System.out.println("Registro Encontrado: ");
			System.out.println("Código do Produto: " + produto.getCodigo());
			System.out.println("Nome do Produto: " + produto.getDescricao());
			System.out.println("Quantidade: " + produto.getQuantidade());
			System.out.println("Preco: " + produto.getPreco());
			System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
			System.out.println("Nome do Fabricante: " + produto.getFabricante().getDescricao());
			
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		
		if(produto == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encontrado: ");
			System.out.println("Código do Produto: " + produto.getCodigo());
			System.out.println("Nome do Produto: " + produto.getDescricao());
			System.out.println("Quantidade: " + produto.getQuantidade());
			System.out.println("Preco: " + produto.getPreco());
			System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
			System.out.println("Nome do Fabricante: " + produto.getFabricante().getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 7L;
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		
		produtoDAO.excluir(produto);
		
		System.out.println("Registro removido:");
		System.out.println("Código do Produto: " + produto.getCodigo());
		System.out.println("Nome do Produto: " + produto.getDescricao());
		System.out.println("Quantidade: " + produto.getQuantidade());
		System.out.println("Preco: " + produto.getPreco());
		System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
		System.out.println("Nome do Fabricante: " + produto.getFabricante().getDescricao());
	
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoProduto = 6L;
		Long codigoFabricante = 3L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);

		System.out.println("Código do Fabricante: " + fabricante.getCodigo());
		System.out.println("Nome do Fabricante: " + fabricante.getDescricao());
				
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);
		
		System.out.println("Produto a Editar:");
		System.out.println("Código do Produto: " + produto.getCodigo());
		System.out.println("Nome do Produto: " + produto.getDescricao());
		System.out.println("Quantidade: " + produto.getQuantidade());
		System.out.println("Preco: " + produto.getPreco());
		System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
		System.out.println("Nome do Fabricante: " + produto.getFabricante().getDescricao());
		
		produto.setDescricao("Produto Alterado");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal(68.90));
		produto.setQuantidade((short)6);

		produtoDAO.editar(produto);
		
		System.out.println("Produto editado:");
		System.out.println("Código do Produto: " + produto.getCodigo());
		System.out.println("Nome do Produto: " + produto.getDescricao());
		System.out.println("Quantidade: " + produto.getQuantidade());
		System.out.println("Preco: " + produto.getPreco());
		System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
		System.out.println("Nome do Fabricante: " + produto.getFabricante().getDescricao());
	}

}
