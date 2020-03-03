package com.detalhe.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Entrega;
import com.detalhe.model.Fechamento;

public class Fechamento2Dto {

	private Long id;
	private Long clinicaId;
	private LocalDate dataFechamento;
	private Double valorTotal;
	private Double valorPgto;
	private String obs;

	public Fechamento2Dto(Fechamento fechamento) {
		this.id = fechamento.getId();
		this.clinicaId = fechamento.getClinica().getId();
		this.dataFechamento = fechamento.getDataFechamento();
		this.valorTotal = fechamento.getValorTotal();
		this.valorPgto = fechamento.getValorPgto();
		this.obs = fechamento.getObs();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClinicaId() {
		return clinicaId;
	}

	public void setClinicaId(Long clinicaId) {
		this.clinicaId = clinicaId;
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

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public static List<FechamentoDto> converter(List<Fechamento> fechamentos) {
		return fechamentos.stream().map(FechamentoDto::new).collect(Collectors.toList());

	}

}
