package br.edu.bsi.sistema.bean;

import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.edu.bsi.sistema.dao.EstadoDAO;
import br.edu.bsi.sistema.domain.Estado;

@SuppressWarnings("serial")
//Realiza a comunicação entre a tela e a parte lógica
@ManagedBean
//Realiza a comunicação entre a tela e a parte lógica a partir da visão (quando abre a tela)
@ViewScoped
public class EstadoBean implements Serializable{
	
	private Estado estado;
	
	private List<Estado> estados;

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void novo(){
		estado = new Estado();
	}
	
	@PostConstruct
	public void lista(){
		try{
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		}catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os estados");
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		try{
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.salvar(estado);
			
			estado = new Estado();
			estados = estadoDAO.listar();
			
			novo();
			
			Messages.addGlobalInfo("Estado salvo com sucesso");
		}catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o registro");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		//captura o componente da linha selecionada, em seguida os atributos
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
	}
	
	public void excluir(ActionEvent evento){
		try{
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			
			estados = estadoDAO.listar();
			
			Messages.addGlobalInfo("Estado removido com sucesso");
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o estado");
			erro.printStackTrace();
		}
	}

}
