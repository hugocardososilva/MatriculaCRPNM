package edu.ifpb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.ifpb.model.Aluno;
import edu.ifpb.service.AlunoService;

@Named
@ViewScoped
public class ListaMB extends AbstractMB{
	
	@Inject
	private AlunoService service;
	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Aluno> alunosFiltrados;
	
	private boolean editar;
	
	
	@PostConstruct
	public void init(){
		
		aluno= new Aluno();
		verificarLogin();
	}
	public void verificarLogin(){
		boolean logado = recuperarSessao();
		if(!logado){
			setKeepMessage();
			displayWarnMessageToUser("Não tem permissão para acessar essa área");
			redirectPage("index.xhtml");
		}
	}
	public void editar(){
		if(aluno.getMatricula()== null || aluno.getMatricula().equals("")){
			aluno.setMatricula(aluno.getId()+5000);
		}
		editar = true;
		
	}
	public String confirmarMatricula(){
		setKeepMessage();
		editar = false; 
		aluno = service.salvar(aluno);
		displayInfoMessageToUser("Matrícula confirmada com sucesso!");
		return "listar?faces-redirect=true";
		
	}
	public String voltar(){
		return "listar?faces-redirect=true";
	}
	public String sair(){
		efetuarLogout();
		return "index?faces-redirect=true";
	}
	public void imprimir(){
		
	}
	
	
	public List<Aluno> carregarAlunos(){
		this.alunos = service.findAll();
		return alunos;
	}

	public List<Aluno> getAlunos() {
		if(alunos == null) carregarAlunos();
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<Aluno> getAlunosFiltrados() {
		return alunosFiltrados;
	}
	public void setAlunosFiltrados(List<Aluno> alunosFiltrados) {
		this.alunosFiltrados = alunosFiltrados;
	}
	public boolean isEditar() {
		return editar;
	}
	public void setEditar(boolean editar) {
		this.editar = editar;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	
	
}
