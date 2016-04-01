package edu.ifpb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Aluno implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private Character sexo;
	
	private Long matricula;
	private boolean matriculado;
	private String responsavel;
	
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	private String estadoCivil;
	private String rg;
	private String orgaoEmissor;
	
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSolicitacao;
	
	@CPF
	private String cpf;
	
	private String curso;
	
	private BigDecimal altura;
	
	private String corOlhos;
	
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	private String cidade;
	private String estado;
	private String cep;
	private String telefoneResidencia;
	private String celular;
	
	@Email
	private String email;
	
	private boolean entregouRG;
	private boolean entregouCPF;
	private boolean entregouCEouFormacao;
	private boolean entregouCompResidencia;
	private boolean entregouCerfReservista;
	private boolean entregouCEMocoConves;
	
	public Aluno() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public String getCorOlhos() {
		return corOlhos;
	}

	public void setCorOlhos(String corOlhos) {
		this.corOlhos = corOlhos;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefoneResidencia() {
		return telefoneResidencia;
	}

	public void setTelefoneResidencia(String telefoneResidencia) {
		this.telefoneResidencia = telefoneResidencia;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEntregouRG() {
		return entregouRG;
	}

	public void setEntregouRG(boolean entregouRG) {
		this.entregouRG = entregouRG;
	}

	public boolean isEntregouCPF() {
		return entregouCPF;
	}

	public void setEntregouCPF(boolean entregouCPF) {
		this.entregouCPF = entregouCPF;
	}

	public boolean isEntregouCEouFormacao() {
		return entregouCEouFormacao;
	}

	public void setEntregouCEouFormacao(boolean entregouCEouFormacao) {
		this.entregouCEouFormacao = entregouCEouFormacao;
	}

	public boolean isEntregouCompResidencia() {
		return entregouCompResidencia;
	}

	public void setEntregouCompResidencia(boolean entregouCompResidencia) {
		this.entregouCompResidencia = entregouCompResidencia;
	}

	public boolean isEntregouCerfReservista() {
		return entregouCerfReservista;
	}

	public void setEntregouCerfReservista(boolean entregouCerfReservista) {
		this.entregouCerfReservista = entregouCerfReservista;
	}

	public boolean isEntregouCEMocoConves() {
		return entregouCEMocoConves;
	}

	public void setEntregouCEMocoConves(boolean entregouCEMocoConves) {
		this.entregouCEMocoConves = entregouCEMocoConves;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", sexo=" + sexo
				+ ", matricula=" + matricula + ", matriculado=" + matriculado
				+ ", responsável=" + responsavel + ", nascimento=" + nascimento
				+ ", estadoCivil=" + estadoCivil + ", rg=" + rg
				+ ", orgaoEmissor=" + orgaoEmissor + ", dataEmissao="
				+ dataEmissao + ", dataSolicitacao=" + dataSolicitacao
				+ ", cpf=" + cpf + ", curso=" + curso + ", altura=" + altura
				+ ", corOlhos=" + corOlhos + ", logradouro=" + logradouro
				+ ", numero=" + numero + ", bairro=" + bairro
				+ ", complemento=" + complemento + ", cidade=" + cidade
				+ ", estado=" + estado + ", cep=" + cep
				+ ", telefoneResidencia=" + telefoneResidencia + ", celular="
				+ celular + ", email=" + email + ", entregouRG=" + entregouRG
				+ ", entregouCPF=" + entregouCPF + ", entregouCEouFormacao="
				+ entregouCEouFormacao + ", entregouCompResidencia="
				+ entregouCompResidencia + ", entregouCerfReservista="
				+ entregouCerfReservista + ", entregouCEMocoConves="
				+ entregouCEMocoConves + "]";
	}
	
	
	
	
}
