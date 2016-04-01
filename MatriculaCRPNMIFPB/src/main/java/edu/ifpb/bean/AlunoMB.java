package edu.ifpb.bean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.StreamedContent;

import edu.ifpb.model.Aluno;
import edu.ifpb.reports.Relatorio;
import edu.ifpb.service.AlunoService;

@Named
@ViewScoped
public class AlunoMB extends AbstractMB {
	
	private boolean aceito;
	
	@Inject
	private AlunoService service;
	private Aluno aluno= new Aluno();
	
	private String senha;
	private StreamedContent relatorioConfirmacao;
	
	@PostConstruct
	public void init(){
	
		System.out.println("iniciando");
	}
	public void salvar(){
		if(!aceito){
			displayErrorMessageToUser("É necessario aceitar a declaração que leu o Edital.");
		}else{
		aluno.setDataSolicitacao(new Date());
		service.salvar(aluno);
		aluno = new Aluno();
		displayInfoMessageToUser("A matrícula foi cadastrada com sucesso!");
		}
	}

	public Aluno getAluno() {
		return aluno;
	}
	public String logar(){
		if(senha.equals("matcrpnm")){
			salvarSessao(senha);
			return "listar?faces-redirect=true";
		}else{
			return "index?faces-redirect=true";
		}
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public boolean isAceito() {
		return aceito;
	}
	public void setAceito(boolean aceito) {
		this.aceito = aceito;
	}
	public StreamedContent getRelatorioConfirmacao() {
		relatorioConfirmacao = Relatorio.gerarConfirmacaoMatricula(aluno);
		return relatorioConfirmacao;
	}
	public void setRelatorioConfirmacao(StreamedContent relatorioConfirmacao) {
		this.relatorioConfirmacao = relatorioConfirmacao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	

}
