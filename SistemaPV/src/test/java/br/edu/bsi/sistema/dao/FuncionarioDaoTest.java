package br.edu.bsi.sistema.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.bsi.sistema.domain.Funcionario;
import br.edu.bsi.sistema.domain.Pessoa;

public class FuncionarioDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Long codigoPessoa = 2L;
		
		//Formatando a Data
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = null;
		try {
			dt = f.parse("16/09/2015");
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
		Funcionario funcionario = new Funcionario();
		
		//Preenche os atributos do objeto
		funcionario.setCarteiraTrabalho("3745947322");
		funcionario.setDataAdmissao(dataSql);
		funcionario.setPessoa(pessoa);
		
		
		//Cria o objeto que permite chamar ações do banco de dados
		FuncionarioDAO funcionariodao = new FuncionarioDAO();
		
		//Invoca a operação de salvar
		funcionariodao.salvar(funcionario);
	}
	
	@Test
	@Ignore
	public void listar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();
		
		for(Funcionario funcionario : resultado){
			System.out.println("Registro Encontrado: ");
			System.out.println("Código do Funcionario: " + funcionario.getCodigo());
			System.out.println("Nome do Funcionario: " + funcionario.getPessoa().getNome());
			System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
			System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);
		
		if(funcionario == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encontrado: ");
			System.out.println("Código do Funcionario: " + funcionario.getCodigo());
			System.out.println("Nome do Funcionario: " + funcionario.getPessoa().getNome());
			System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
			System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);
		
		funcionarioDAO.excluir(funcionario);
		
		System.out.println("Registro removido:");
		System.out.println("Código do Funcionario: " + funcionario.getCodigo());
		System.out.println("Nome do Funcionario: " + funcionario.getPessoa().getNome());
		System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
		System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
	
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoPessoa = 1L;
		Long codigoFuncionario = 2L;
				
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigoFuncionario);
		
		//Formatando a Data
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = null;
		try {
			dt = f.parse("10/04/2016");
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
		
		System.out.println("Funcionario a Editar:");
		System.out.println("Código do Funcionario: " + funcionario.getCodigo());
		System.out.println("Nome do Funcionario: " + funcionario.getPessoa().getNome());
		System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
		System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
		
		funcionario.setCarteiraTrabalho("7484738309");
		funcionario.setDataAdmissao(dataSql);
		funcionario.setPessoa(pessoa);

		funcionarioDAO.editar(funcionario);
		
		System.out.println("Funcionário Editado:");
		System.out.println("Código do Funcionario: " + funcionario.getCodigo());
		System.out.println("Nome do Funcionario: " + funcionario.getPessoa().getNome());
		System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
		System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
	}


}
