package com.detalhe.form;

import java.time.LocalDate;

public class AddPgtoForm {

	private Long id;
	private Long fechamentoId;
	private LocalDate dataPagamento;
	private Double valor;
	private String obs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Long getFechamentoId() {
		return fechamentoId;
	}

	public void setFechamentoId(Long fechamentoId) {
		this.fechamentoId = fechamentoId;
	}
	
	

}
