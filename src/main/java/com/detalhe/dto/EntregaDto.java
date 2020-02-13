package com.detalhe.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Entrega;
import com.detalhe.model.Pedido;
import com.detalhe.model.StatusFechamento;

public class EntregaDto {
	
	private Long id;
	private LocalDate dataEntrega;
	private String recebedor;
	private StatusFechamento statusFechamento;
	private Long clinicaId;
	private String obs;
	private Double totalEntrega;
	private List<Pedido2Dto> pedidos;
	
	
	public EntregaDto(Entrega entrega) {
		this.id = entrega.getId();
		this.dataEntrega = entrega.getDataEntrega();
		this.recebedor = entrega.getRecebedor();
		this.statusFechamento = entrega.getStatusFechamento();
		this.clinicaId = entrega.getClinica().getId();
		this.obs = entrega.getObs();
		this.totalEntrega = entrega.getTotalEntrega();
		this.pedidos = Pedido2Dto.converter(entrega.getPedidos());
		
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

	public List<Pedido2Dto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido2Dto> pedidos) {
		this.pedidos = pedidos;
	}
	
	public Double getTotalEntrega() {
		return totalEntrega;
	}

	public void setTotalEntrega(Double totalEntrega) {
		this.totalEntrega = totalEntrega;
	}

	public static List<EntregaDto> converter(List<Entrega> entregas) {
		return entregas.stream().map(EntregaDto::new).collect(Collectors.toList());

	}
	
	

}
