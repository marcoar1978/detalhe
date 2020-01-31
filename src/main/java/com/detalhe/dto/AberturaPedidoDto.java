package com.detalhe.dto;

import java.time.LocalDate;

public class AberturaPedidoDto {
	
	private Long pedidoId;
	
	private LocalDate dataPedido;

	
	
	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	
}
