package edu.ifpb.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import edu.ifpb.model.Aluno;



public class AlunoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Aluno salvar(Aluno aluno){
		return manager.merge(aluno);
	}
	@SuppressWarnings("unchecked")
	public List<Aluno> findAll(){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Aluno.class);
		
		return criteria.addOrder(Order.asc("matricula")).list();
	}
	public Aluno getByMatricula(Long matricula){
		try{
			return manager.createQuery("from Aluino A where matricula = :matricula",Aluno.class)
					.setParameter("matricula", matricula).getSingleResult();
		}catch(NoResultException e ){
			return null;
		}
	}
	public Aluno find(Long id){
		return manager.find(Aluno.class, id);
	}
}
