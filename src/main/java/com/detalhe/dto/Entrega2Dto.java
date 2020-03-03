package com.detalhe.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Entrega;
import com.detalhe.model.Fechamento;
import com.detalhe.model.Pedido;
import com.detalhe.model.StatusFechamento;

public class Entrega2Dto {

	private Long id;
	private LocalDate dataEmissao;
	private LocalDate dataEntrega;
	private String recebedor;
	private StatusFechamento statusFechamento;
	private Long clinicaId;
	private String obs;
	private Double totalEntrega;
	private Fechamento2Dto fechamento;

	public Entrega2Dto(Entrega entrega) {
		this.id = entrega.getId();
		this.dataEmissao = entrega.getDataCad();
		this.dataEntrega = entrega.getDataEntrega();
		this.recebedor = entrega.getRecebedor();
		this.statusFechamento = entrega.getStatusFechamento();
		this.clinicaId = entrega.getClinica().getId();
		this.obs = entrega.getObs();
		this.totalEntrega = entrega.getTotalEntrega();
		this.fechamento = (entrega.getFechamento() == null)? null : new Fechamento2Dto(entrega.getFechamento());

	}

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

	public String getRecebedor() {
		return recebedor;
	}

	public void setRecebedor(String recebedor) {
		this.recebedor = recebedor;
	}

	public Long getClinicaId() {
		return clinicaId;
	}

	public void setClinicaId(Long clinicaId) {
		this.clinicaId = clinicaId;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Double getTotalEntrega() {
		return totalEntrega;
	}

	public void setTotalEntrega(Double totalEntrega) {
		this.totalEntrega = totalEntrega;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public StatusFechamento getStatusFechamento() {
		return statusFechamento;
	}

	public void setStatusFechamento(StatusFechamento statusFechamento) {
		this.statusFechamento = statusFechamento;
	}
	
	public Fechamento2Dto getFechamento() {
		return fechamento;
	}

	public void setFechamento(Fechamento2Dto fechamento) {
		this.fechamento = fechamento;
	}

	public static List<EntregaDto> converter(List<Entrega> entregas) {
		return entregas.stream().map(EntregaDto::new).collect(Collectors.toList());

	}

}
