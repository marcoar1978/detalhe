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
public class Fechamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataFechamento;
	private Double valorFechamento;
	private Double desconto;
	private Double valorTotal;
	private Double valorPgto;

	@ManyToOne
	@JoinColumn(name = "clinica_id")
	private Clinica clinica;

	@OneToMany(mappedBy = "fechamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Entrega> entregas;

	@OneToMany(mappedBy = "fechamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pgto> pgtos;

	private String obs;

	private LocalDate dataCad;
	private LocalDate dataAlt;

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

	public LocalDate getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorPgto() {
		return valorPgto;
	}

	public void setValorPgto(Double valorPgto) {
		this.valorPgto = valorPgto;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
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

	public List<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}

	public List<Pgto> getPgtos() {
		return pgtos;
	}

	public void setPgtos(List<Pgto> pgtos) {
		this.pgtos = pgtos;
	}

	public Double getValorFechamento() {
		return valorFechamento;
	}

	public void setValorFechamento(Double valorFechamento) {
		this.valorFechamento = valorFechamento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

}
