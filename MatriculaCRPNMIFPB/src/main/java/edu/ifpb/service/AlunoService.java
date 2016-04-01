package edu.ifpb.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import edu.ifpb.model.Aluno;
import edu.ifpb.repository.AlunoRepository;
import edu.ifpb.util.Transacional;

public class AlunoService implements Serializable {

	@Inject
	private AlunoRepository repository;
	
	@Transacional
	public Aluno salvar(Aluno aluno){
		return repository.salvar(aluno);
	}
	public  List<Aluno> findAll(){
		return repository.findAll();
	}
	public Aluno find(Long id){
		return repository.find(id);
	}
	public Aluno getByMatricula(Long matricula){
		return repository.getByMatricula(matricula);
	}
}
