package com.detalhe.form;

import java.time.LocalDate;
import java.util.List;

public class AddFechamentoForm {

	private Long clinicaId;
	private LocalDate dataFechamento;
	private Double valorTotal;
	private Double valorPgto;
	private String obs;
	private Long[] entregasId;

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

	public Long[] getEntregasId() {
		return entregasId;
	}

	public void setEntregasId(Long[] entregasId) {
		this.entregasId = entregasId;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	

	

}
