package br.edu.bsi.sistema.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.bsi.sistema.domain.Pessoa;
import br.edu.bsi.sistema.domain.Usuario;

public class UsuarioDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Long codigoPessoa = 2L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
				
		//Cria o objeto que ira receber os dados
		Usuario usuario = new Usuario();
		
		//Preenche os atributos do objeto
		usuario.setSenha("123456");
		usuario.setAtivo(true);
		usuario.setTipo('A');
		usuario.setPessoa(pessoa);
		
		//Cria o objeto que permite chamar ações do banco de dados
		UsuarioDAO usuariodao = new UsuarioDAO();
		
		//Invoca a operação de salvar
		usuariodao.salvar(usuario);
	}
	
	@Test
	@Ignore
	public void listar(){
		UsuarioDAO usuariodao = new UsuarioDAO();
		List<Usuario> resultado = usuariodao.listar();
		
		for(Usuario usuario : resultado){
			System.out.println("Registro Encontrado: ");
			System.out.println("Código do Usuario: " + usuario.getCodigo());
			System.out.println("Nome do Usuario: " + usuario.getPessoa().getNome());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo: " + usuario.getAtivo());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		Usuario usuario = usuariodao.buscar(codigo);
		
		if(usuario == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encontrado: ");
			System.out.println("Código do Usuario: " + usuario.getCodigo());
			System.out.println("Nome do Usuario: " + usuario.getPessoa().getNome());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo: " + usuario.getAtivo());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		Usuario usuario = usuariodao.buscar(codigo);
		
		usuariodao.excluir(usuario);
		
		System.out.println("Registro removido:");
		System.out.println("Código do Usuario: " + usuario.getCodigo());
		System.out.println("Nome do Usuario: " + usuario.getPessoa().getNome());
		System.out.println("Tipo: " + usuario.getTipo());
		System.out.println("Ativo: " + usuario.getAtivo());
	
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoPessoa = 1L;
		Long codigoUsuario = 2L;
				
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		Usuario usuario = usuariodao.buscar(codigoUsuario);
		
		System.out.println("Funcionario a Editar:");
		System.out.println("Código do Usuario: " + usuario.getCodigo());
		System.out.println("Nome do Usuario: " + usuario.getPessoa().getNome());
		System.out.println("Tipo: " + usuario.getTipo());
		System.out.println("Ativo: " + usuario.getAtivo());
		
		usuario.setSenha("102030");
		usuario.setAtivo(true);
		usuario.setTipo('C');
		usuario.setPessoa(pessoa);

		usuariodao.editar(usuario);
		
		System.out.println("Funcionário Editado:");
		System.out.println("Código do Usuario: " + usuario.getCodigo());
		System.out.println("Nome do Usuario: " + usuario.getPessoa().getNome());
		System.out.println("Tipo: " + usuario.getTipo());
		System.out.println("Ativo: " + usuario.getAtivo());
	}


}
