package br.edu.bsi.sistema.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.bsi.sistema.domain.Funcionario;
import br.edu.bsi.sistema.domain.ItemVenda;
import br.edu.bsi.sistema.domain.Produto;

public class ItemVendaDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Long codigoFuncionario = 1L;
		Long codigoProduto = 3L;
		
		FuncionarioDAO funcionariodao = new FuncionarioDAO();
		Funcionario funcionario = funcionariodao.buscar(codigoFuncionario);
		
		ProdutoDAO produtodao = new ProdutoDAO();
		Produto produto = produtodao.buscar(codigoProduto);
				
		//Cria o objeto que ira receber os dados
		ItemVenda itemVenda = new ItemVenda();
		
		//Preenche os atributos do objeto
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade((short)21);
		itemVenda.setPrecoParcial(new BigDecimal(19.90));
		itemVenda.setFuncionario(funcionario);
		
		//Cria o objeto que permite chamar ações do banco de dados
		ItemVendaDAO itemVendaDao = new ItemVendaDAO();
		
		//Invoca a operação de salvar
		itemVendaDao.salvar(itemVenda);
	}
	
	@Test
	@Ignore
	public void listar(){
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		List<ItemVenda> resultado = itemVendaDAO.listar();
		
		for(ItemVenda itemVenda : resultado){
			System.out.println("Registro Encontrado: ");
			System.out.println("Código do ItemVenda: " + itemVenda.getCodigo());
			System.out.println("Produto: " + itemVenda.getProduto().getDescricao());
			System.out.println("Quantidade: " + itemVenda.getQuantidade());
			System.out.println("Preco Parcial: " + itemVenda.getPrecoParcial());
			System.out.println("Funcionario: " + itemVenda.getFuncionario().getPessoa().getNome());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);
		
		if(itemVenda == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encontrado: ");
			System.out.println("Código do ItemVenda: " + itemVenda.getCodigo());
			System.out.println("Produto: " + itemVenda.getProduto().getDescricao());
			System.out.println("Quantidade: " + itemVenda.getQuantidade());
			System.out.println("Preco Parcial: " + itemVenda.getPrecoParcial());
			System.out.println("Funcionario: " + itemVenda.getFuncionario().getPessoa().getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 4L;
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);
		
		itemVendaDAO.excluir(itemVenda);
		
		System.out.println("Registro removido:");
		System.out.println("Código do ItemVenda: " + itemVenda.getCodigo());
		System.out.println("Produto: " + itemVenda.getProduto().getDescricao());
		System.out.println("Quantidade: " + itemVenda.getQuantidade());
		System.out.println("Preco Parcial: " + itemVenda.getPrecoParcial());
		System.out.println("Funcionario: " + itemVenda.getFuncionario().getPessoa().getNome());
	
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoItem = 2L;
		Long codigoFuncionario = 1L;
		Long codigoProduto = 4L;
				
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigoItem);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigoFuncionario);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);
		
		System.out.println("Item Venda a Editar:");
		System.out.println("Código do ItemVenda: " + itemVenda.getCodigo());
		System.out.println("Produto: " + itemVenda.getProduto().getDescricao());
		System.out.println("Quantidade: " + itemVenda.getQuantidade());
		System.out.println("Preco Parcial: " + itemVenda.getPrecoParcial());
		System.out.println("Funcionario: " + itemVenda.getFuncionario().getPessoa().getNome());
		
		
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade((short)22);
		itemVenda.setPrecoParcial(new BigDecimal(29.90));
		itemVenda.setFuncionario(funcionario);

		itemVendaDAO.editar(itemVenda);
		
		System.out.println("Item Venda Editado:");
		System.out.println("Código do ItemVenda: " + itemVenda.getCodigo());
		System.out.println("Produto: " + itemVenda.getProduto().getDescricao());
		System.out.println("Quantidade: " + itemVenda.getQuantidade());
		System.out.println("Preco Parcial: " + itemVenda.getPrecoParcial());
		System.out.println("Funcionario: " + itemVenda.getFuncionario().getPessoa().getNome());
	}


}
