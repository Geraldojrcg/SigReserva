package com.ufrn.imd.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ufrn.imd.model.Reserva;
import com.ufrn.imd.model.Usuario;

@Stateless
public class ReservaRepository {
	@PersistenceContext
	private EntityManager em;
	
	public Reserva adicionar(Reserva reserva) {
		if(reserva.getId() == 0) {
			em.persist(reserva);
		} else {
			em.merge(reserva);
		}
		return reserva;
	}
	
	public void remover(Reserva reserva) {
		reserva = em.find(Reserva.class, reserva.getId());
		em.remove(reserva);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> listarReserva(){
		return (List<Reserva>) em.createQuery("select r from Reserva r")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> listarReservaPorUsuario(Usuario usuario){
		String jpaql = "select r from Reserva r where r.usuario.id = :idUsuario";
		Query q = em.createQuery(jpaql);
		q.setParameter("idUsuario", usuario.getId());
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> buscarReservaPorData(String data) {
		String jpaql = "select r from Reserva r where r.dataReserva = :data";
		Query q = em.createQuery(jpaql);
		q.setParameter("data", data);
		return q.getResultList();
	}
}
