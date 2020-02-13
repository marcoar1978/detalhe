package com.detalhe.form;

import java.time.LocalDate;

public class EntregaForm {

	private Long clinicaId;
	private String obs;
	private Double totalEntrega;
	private Long[] pedidosId;

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

	public Long[] getPedidosId() {
		return pedidosId;
	}

	public void setPedidosId(Long[] pedidosId) {
		this.pedidosId = pedidosId;
	}

	public Double getTotalEntrega() {
		return totalEntrega;
	}
	

}
