package com.ufrn.imd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Sala {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SALA")
	@SequenceGenerator(name="SEQ_SALA", sequenceName="id_seq_sala", allocationSize=1)
	private int id;
	
	private String nome;
	
	private Boolean isReservada;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getIsReservada() {
		return isReservada;
	}

	public void setIsReservada(Boolean isReservada) {
		this.isReservada = isReservada;
	}
}
