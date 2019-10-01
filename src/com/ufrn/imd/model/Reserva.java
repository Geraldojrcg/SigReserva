package com.ufrn.imd.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_RESERVA")
	@SequenceGenerator(name="SEQ_RESERVA", sequenceName="id_seq_reserva", allocationSize=1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Sala sala;
	
	@ManyToOne
	@JoinColumn(name="id_sala")
	private Usuario usuario;
	
	@Temporal(TemporalType.DATE)
	private Date dataReserva;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
