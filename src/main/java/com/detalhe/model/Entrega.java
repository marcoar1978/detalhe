package com.detalhe.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;

@Entity
public class Entrega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataEntrega;
	private String recebedor;

	@ManyToOne
	@JoinColumn(name = "clinica_id")
	private Clinica clinica;

	@ManyToOne
	@JoinColumn(name = "fechamento_id")
	private Fechamento fechamento;
	
	@Enumerated
	private StatusFechamento statusFechamento = StatusFechamento.NAO;
	
	@OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pedido> pedidos;

	private String obs;

	private LocalDate dataCad;
	private LocalDate dataAlt;
	
	private Double totalEntrega;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Fechamento getFechamento() {
		return fechamento;
	}

	public void setFechamento(Fechamento fechamento) {
		this.fechamento = fechamento;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public LocalDate getDataCad() {
		return dataCad;
	}

	public void setDataCad(LocalDate dataCad) {
		this.dataCad = dataCad;
	}

	public LocalDate getDataAlt() {
		return dataAlt;
	}

	public void setDataAlt(LocalDate dataAlt) {
		this.dataAlt = dataAlt;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRecebedor() {
		return recebedor;
	}

	public void setRecebedor(String recebedor) {
		this.recebedor = recebedor;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public StatusFechamento getStatusFechamento() {
		return statusFechamento;
	}

	public void setStatusFechamento(StatusFechamento statusFechamento) {
		this.statusFechamento = statusFechamento;
	}

	public Double getTotalEntrega() {
		return totalEntrega;
	}

	public void setTotalEntrega(Double totalEntrega) {
		this.totalEntrega = totalEntrega;
	}
	
	

}
