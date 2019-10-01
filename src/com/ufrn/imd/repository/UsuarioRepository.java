package com.ufrn.imd.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ufrn.imd.model.Usuario;

@Stateless
public class UsuarioRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public Usuario getUsuario(String login, String senha) {
		try {
			Query q = em.createQuery("select u from Usuario u where login = :login and senha = :senha");
			q.setParameter("login", login);
			q.setParameter("senha", senha);
			return (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
