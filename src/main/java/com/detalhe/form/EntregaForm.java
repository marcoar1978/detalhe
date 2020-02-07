package com.detalhe.form;

import java.time.LocalDate;

public class EntregaForm {
	
	private LocalDate dataEntrega;
	private Long clinicaId;
	private String obs;
	private Long[] pedidosId;
	
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
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
	public Long[] getPedidosId() {
		return pedidosId;
	}
	public void setPedidosId(Long[] pedidosId) {
		this.pedidosId = pedidosId;
	}
	
	

}
