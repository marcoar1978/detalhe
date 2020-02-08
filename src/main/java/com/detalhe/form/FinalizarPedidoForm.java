package com.detalhe.form;

import java.time.LocalDate;

import com.detalhe.model.Protetico;

public class FinalizarPedidoForm {

	private Long pedidoId;
	private Long clinicaId;
	private Long dentistaId;
	private String nomePaciente;
	private Long proteticoId;
	private Integer desconto;
	private LocalDate dataPedido;
	private LocalDate dataCad;
	private String obs;
	private Integer prazo;
	private Double valorTotal;
	private Double valorLiquido;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Long getClinicaId() {
		return clinicaId;
	}

	public void setClinicaId(Long clinicaId) {
		this.clinicaId = clinicaId;
	}

	public Long getDentistaId() {
		return dentistaId;
	}

	public void setDentistaId(Long dentistaId) {
		this.dentistaId = dentistaId;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public Long getProteticoId() {
		return proteticoId;
	}

	public void setProteticoId(Long proteticoId) {
		this.proteticoId = proteticoId;
	}

	public Integer getDesconto() {
		return desconto;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	public Integer getPrazo() {
		return prazo;
	}

	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataCad() {
		return dataCad;
	}

	public void setDataCad(LocalDate dataCad) {
		this.dataCad = dataCad;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	

}
