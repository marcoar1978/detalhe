package com.detalhe.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Clinica;
import com.detalhe.model.Pedido;
import com.detalhe.model.StatusEntrega;
import com.detalhe.model.StatusPedido;

public class Pedido2Dto {
	
	private Long id;
	private LocalDate dataPedido;
	private String clinica;
	private Long clinicaId;
	private String dentista;
	private String nomePaciente;
	private Integer prazo;
	private LocalDate dataEntregaPrevista;
	private LocalDate dataEntrega;
	private String obs;

	private Integer desconto;

	private Double valorTotal;
	private Double valorLiquido;
	private String usuario;
	private String protetico;
	private StatusPedido statusPedido;
	private StatusEntrega statusEntrega;
	private List<ItemPadraoDto> itensPadrao;

	public Pedido2Dto(Pedido pedido) {
		this.id = pedido.getId();
		this.dataPedido = pedido.getDataPedido();
		this.clinica = pedido.getClinica().getNome();
		this.clinicaId = pedido.getClinica().getId();
		
		this.dentista = pedido.getDentista().getNome();
		this.nomePaciente = pedido.getNomePaciente();
		this.prazo = pedido.getPrazo();
		this.dataEntregaPrevista = pedido.getDataEntregaPrevista();
		this.obs = pedido.getObs();
		this.desconto = pedido.getDesconto();
		this.valorTotal = pedido.getValorTotal();
		this.valorLiquido = pedido.getValorLiquido();
		this.usuario = pedido.getUsuario().getNome();
		this.protetico = pedido.getProtetico().getNome();
		this.statusPedido = pedido.getStatusPedido();
		this.statusEntrega = pedido.getStatusEntrega();
		this.dataEntrega = pedido.getDataEntrega();
		this.itensPadrao = ItemPadraoDto.converter(pedido.getItensPadrao());

	}

	public Long getClinicaId() {
		return clinicaId;
	}

	public void setClinicaId(Long clinicaId) {
		this.clinicaId = clinicaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getClinica() {
		return clinica;
	}

	public void setClinica(String clinica) {
		this.clinica = clinica;
	}

	public String getDentista() {
		return dentista;
	}

	public void setDentista(String dentista) {
		this.dentista = dentista;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public Integer getPrazo() {
		return prazo;
	}

	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}

	public LocalDate getDataEntregaPrevista() {
		return dataEntregaPrevista;
	}

	public void setDataEntregaPrevista(LocalDate dataEntregaPrevista) {
		this.dataEntregaPrevista = dataEntregaPrevista;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Integer getDesconto() {
		return desconto;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getProtetico() {
		return protetico;
	}

	public void setProtetico(String protetico) {
		this.protetico = protetico;
	}

	public List<ItemPadraoDto> getItensPadrao() {
		return itensPadrao;
	}

	public void setItensPadrao(List<ItemPadraoDto> itensPadrao) {
		this.itensPadrao = itensPadrao;
	}
	
	public static List<Pedido2Dto> converter(List<Pedido> pedidos) {
		return pedidos.stream().map(Pedido2Dto::new).collect(Collectors.toList());

	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public StatusEntrega getStatusEntrega() {
		return statusEntrega;
	}

	public void setStatusEntrega(StatusEntrega statusEntrega) {
		this.statusEntrega = statusEntrega;
	}
	
	


}
