package com.ufrn.imd.controller;

import java.io.Serializable;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import com.ufrn.imd.model.Sala;
import com.ufrn.imd.repository.SalaRepository;

public class SalaMBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Sala sala;
	private DataModel<Sala> salaModel;
	
	@Inject
	private SalaRepository salaRepositorio;
	
	public SalaMBean() {
		sala = new Sala();
	}
	
	public String novaSala() {
		sala = new Sala();
		return "/pages/salas/form.jsf";
	}

	public String listarSalas() {
		salaModel = new ListDataModel<Sala>(salaRepositorio.listarSala());
		return "/pages/salas/list.jsf";
	}
	
	public String cadastrarSala() {
		salaRepositorio.adicionar(sala);
		sala = new Sala();
		return "/pages/salas/form.jsf";
	}
	
	public String removerSala() {
		Sala salaRemovida = salaModel.getRowData();
		salaRepositorio.remover(salaRemovida);
		salaModel = new ListDataModel<Sala>(salaRepositorio.listarSala());
		return "/pages/salas/list.jsf";
	}
	
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public DataModel<Sala> getMateriaisModel() {
		return salaModel;
	}

	public void setSalaModel(DataModel<Sala> salaModel) {
		this.salaModel = salaModel;
	}
}
