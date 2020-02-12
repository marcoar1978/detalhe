package com.detalhe.form;

import java.time.LocalDate;

public class RecebimentoDto {

	private Long entregaId;
	private String recebedor;
	private LocalDate dataEntrega;

	public Long getEntregaId() {
		return entregaId;
	}

	public String getRecebedor() {
		return recebedor;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

}
