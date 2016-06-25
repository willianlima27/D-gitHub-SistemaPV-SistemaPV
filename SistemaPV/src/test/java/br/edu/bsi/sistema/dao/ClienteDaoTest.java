package br.edu.bsi.sistema.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.bsi.sistema.domain.Cliente;
import br.edu.bsi.sistema.domain.Pessoa;

public class ClienteDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Long codigoPessoa = 2L;
		
		//Formatando a Data
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = null;
		try {
			dt = f.parse("01/09/2010");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dt2 = f.format(dt);
		java.sql.Date dataSql = null;
		try {
			dataSql = new java.sql.Date(f.parse(dt2).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
				
		//Cria o objeto que ira receber os dados
		Cliente cliente = new Cliente();
		
		//Preenche os atributos do objeto
		cliente.setDataCadastro(dataSql);
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);
		
		
		//Cria o objeto que permite chamar ações do banco de dados
		ClienteDAO clientedao = new ClienteDAO();
		
		//Invoca a operação de salvar
		clientedao.salvar(cliente);

	}
	
	@Test
	@Ignore
	public void listar(){
		
		ClienteDAO clientedao = new ClienteDAO();
		List<Cliente> resultado = clientedao.listar();
		
		for(Cliente cliente : resultado){
			System.out.println("Registro Encontrado: ");
			System.out.println("Código do Cliente: " + cliente.getCodigo());
			System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
			System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
			System.out.println("Liberado: " + cliente.getLiberado());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		ClienteDAO clientedao = new ClienteDAO();
		Cliente cliente = clientedao.buscar(codigo);
		
		if(cliente == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encontrado: ");
			System.out.println("Código do Cliente: " + cliente.getCodigo());
			System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
			System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
			System.out.println("Liberado: " + cliente.getLiberado());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		
		ClienteDAO clientedao = new ClienteDAO();
		Cliente cliente = clientedao.buscar(codigo);
		
		clientedao.excluir(cliente);
		
		System.out.println("Registro removido:");
		System.out.println("Código do Cliente: " + cliente.getCodigo());
		System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
		System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
		System.out.println("Liberado: " + cliente.getLiberado());
	
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoPessoa = 1L;
		Long codigoCliente = 2L;
				
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		ClienteDAO clientedao = new ClienteDAO();
		Cliente cliente = clientedao.buscar(codigoCliente);
		
		//Formatando a Data
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = null;
		try {
			dt = f.parse("10/05/2012");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dt2 = f.format(dt);
		java.sql.Date dataSql = null;
		try {
			dataSql = new java.sql.Date(f.parse(dt2).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Cliente a Editar:");
		System.out.println("Código do Cliente: " + cliente.getCodigo());
		System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
		System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
		System.out.println("Liberado: " + cliente.getLiberado());
		
		cliente.setDataCadastro(dataSql);
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);

		clientedao.editar(cliente);
		
		System.out.println("Cliente Editado:");
		System.out.println("Código do Cliente: " + cliente.getCodigo());
		System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
		System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
		System.out.println("Liberado: " + cliente.getLiberado());
	}


}
