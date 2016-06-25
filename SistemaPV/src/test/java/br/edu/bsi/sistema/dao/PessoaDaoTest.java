package br.edu.bsi.sistema.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.bsi.sistema.domain.Cidade;
import br.edu.bsi.sistema.domain.Pessoa;


public class PessoaDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Long codigoCidade = 2L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		//Cria o objeto que ira receber os dados
		Pessoa pessoa = new Pessoa();
		
		//Preenche os atributos do objeto
		pessoa.setNome("Pessoa Excluir");
		pessoa.setCpf("859.298.098-21");
		pessoa.setRg("38293994");
		pessoa.setLogradouro("Av Brasil");
		pessoa.setNumero((short)200);
		pessoa.setBairro("Centro");
		pessoa.setCep("85555-000");
		pessoa.setComplemento("Casa");
		pessoa.setTelefone("(46)8940-2834");
		pessoa.setCelular("(46)9078-7878");
		pessoa.setEmail("excluir@email.com.br");
		pessoa.setCidade(cidade);
		
		//Cria o objeto que permite chamar ações do banco de dados
		PessoaDAO pessoadao = new PessoaDAO();
		
		//Invoca a operação de salvar
		pessoadao.salvar(pessoa);
	}
	
	@Test
	@Ignore
	public void listar(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();
		
		for(Pessoa pessoa : resultado){
			System.out.println("Registro Encontrado: ");
			System.out.println("Código da Pessoa: " + pessoa.getCodigo());
			System.out.println("Nome da Pessoa: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("Cidade: " + pessoa.getCidade().getNome());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		if(pessoa == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encontrado: ");
			System.out.println("Código da Pessoa: " + pessoa.getCodigo());
			System.out.println("Nome da Pessoa: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("Cidade: " + pessoa.getCidade().getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		pessoaDAO.excluir(pessoa);
		
		System.out.println("Registro removido:");
		System.out.println("Código da Pessoa: " + pessoa.getCodigo());
		System.out.println("Nome da Pessoa: " + pessoa.getNome());
		System.out.println("CPF: " + pessoa.getCpf());
		System.out.println("Cidade: " + pessoa.getCidade().getNome());
	
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoPessoa = 2L;
		Long codigoCidade = 2L;
				
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		System.out.println("Pessoa a Editar:");
		System.out.println("Código da Pessoa: " + pessoa.getCodigo());
		System.out.println("Nome da Pessoa: " + pessoa.getNome());
		System.out.println("CPF: " + pessoa.getCpf());
		System.out.println("Cidade: " + pessoa.getCidade().getNome());
		
		pessoa.setNome("Pessoa Editada");
		pessoa.setCpf("38494028373");
		pessoa.setRg("3298342932");
		pessoa.setLogradouro("Rua dos Ipiranga");
		pessoa.setNumero((short)10);
		pessoa.setBairro("Centro");
		pessoa.setCep("85555-000");
		pessoa.setComplemento("");
		pessoa.setTelefone("(46)3289-2342");
		pessoa.setCelular("(46)2342-4342");
		pessoa.setEmail("editado@email.com.br");
		pessoa.setCidade(cidade);

		pessoaDAO.editar(pessoa);
		
		System.out.println("Pessoa Editada:");
		System.out.println("Código da Pessoa: " + pessoa.getCodigo());
		System.out.println("Nome da Pessoa: " + pessoa.getNome());
		System.out.println("CPF: " + pessoa.getCpf());
		System.out.println("Cidade: " + pessoa.getCidade().getNome());
	}


}
