package br.edu.bsi.sistema.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.edu.bsi.sistema.dao.FabricanteDAO;
import br.edu.bsi.sistema.domain.Fabricante;

@SuppressWarnings("serial")
//Realiza a comunicação entre a tela e a parte lógica
@ManagedBean
//Realiza a comunicação entre a tela e a parte lógica a partir da visão (quando abre a tela)
@ViewScoped
public class FabricanteBean implements Serializable{
	
	private Fabricante fabricante;
	
	private List<Fabricante> fabricantes;

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public void novo(){
		fabricante = new Fabricante();
	}
	
	@PostConstruct
	public void lista(){
		try{
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
		}catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os fabricantes");
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		try{
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.salvar(fabricante);
			
			fabricante = new Fabricante();
			fabricantes = fabricanteDAO.listar();
			
			novo();
			
			Messages.addGlobalInfo("Fabricante salvo com sucesso");
		}catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o registro");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
	}
	
	public void excluir(ActionEvent evento){
		try{
			fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
		
			FabricanteDAO fabricateDAO = new FabricanteDAO();
			fabricateDAO.excluir(fabricante);
			
			fabricantes = fabricateDAO.listar();
			
			Messages.addGlobalInfo("Fabricante removido com sucesso");
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o Fabricante");
			erro.printStackTrace();
		}
		
	}

}
