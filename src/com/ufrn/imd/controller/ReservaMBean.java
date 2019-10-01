package com.ufrn.imd.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.ufrn.imd.model.Reserva;
import com.ufrn.imd.model.Usuario;
import com.ufrn.imd.repository.ReservaRepository;

@Named
@SessionScoped
public class ReservaMBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Reserva reserva;
	private DataModel<Reserva> reservaModel;
	
	@Inject
	private UsuarioMBean usuarioMBean;
	
	@Inject
	private ReservaRepository reservaRepositorio;
	
	public ReservaMBean() {
		reserva = new Reserva();
	}
	
	public String novaReserva() {
		reserva = new Reserva();
		return "/pages/reservas/form.jsf";
	}

	public String listarReservas() {
		reservaModel = new ListDataModel<Reserva>(reservaRepositorio.listarReserva());
		return "/pages/reservas/list.jsf";
	}
	
	public String listarReservasPorUsuario(Usuario usuario) {
		reservaModel = new ListDataModel<Reserva>(reservaRepositorio.listarReservaPorUsuario(usuario));
		return "/pages/reservas/list.jsf";
	}
	
	public String cadastrarReserva() {
		reserva.setUsuario(usuarioMBean.getUsuarioLogado());
		reservaRepositorio.adicionar(reserva);
		reserva = new Reserva();
		return "/pages/Reserva/form.jsf";
	}
	
	public String removerReserva() {
		Reserva reservaRemovida = reservaModel.getRowData();
		reservaRepositorio.remover(reservaRemovida);
		reservaModel = new ListDataModel<Reserva>(reservaRepositorio.listarReserva());
		return "/pages/reserva/list.jsf";
	}
	
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva Reserva) {
		this.reserva = Reserva;
	}

	public DataModel<Reserva> getMateriaisModel() {
		return reservaModel;
	}

	public void setReservaModel(DataModel<Reserva> reservaModel) {
		this.reservaModel = reservaModel;
	}

	public UsuarioMBean getUsuarioMBean() {
		return usuarioMBean;
	}

	public void setUsuarioMBean(UsuarioMBean usuarioMBean) {
		this.usuarioMBean = usuarioMBean;
	}
}
