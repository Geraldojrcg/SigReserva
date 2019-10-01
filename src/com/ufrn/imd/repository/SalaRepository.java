package com.ufrn.imd.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ufrn.imd.model.Sala;

@Stateless
public class SalaRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public Sala adicionar(Sala sala) {
		if(sala.getId() == 0) {
			em.persist(sala);
		} else {
			em.merge(sala);
		}
		return sala;
	}
	
	public void remover(Sala sala) {
		sala = em.find(Sala.class, sala.getId());
		em.remove(sala);
	}
	
	@SuppressWarnings("unchecked")
	public List<Sala> listarSala(){
		return (List<Sala>) em.createQuery("select s from Sala s")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Sala> buscarSala(String codigo) {
		String jpaql = "select s from Sala s where s.codigo = :codigo";
		Query q = em.createQuery(jpaql);
		q.setParameter("codigo", codigo);
		return q.getResultList();
	}
}
