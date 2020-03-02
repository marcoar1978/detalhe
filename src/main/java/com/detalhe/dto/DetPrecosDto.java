package com.detalhe.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.DetPrecos;

public class DetPrecosDto {
	
	private Long produtoId;
	private String nome;
	private Double valor;
	private Integer padraoPrazoEntrega;
	private Long listaId;
	
	public DetPrecosDto(DetPrecos detPrecos) {
		this.produtoId = detPrecos.getProduto().getId();
		this.nome = detPrecos.getProduto().getNome();
		this.valor = detPrecos.getValor();
		this.padraoPrazoEntrega = detPrecos.getProduto().getPadraoPrazoEntrega();
		this.listaId = detPrecos.getListaPrecos().getId();
		
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getPadraoPrazoEntrega() {
		return padraoPrazoEntrega;
	}

	public void setPadraoPrazoEntrega(Integer padraoPrazoEntrega) {
		this.padraoPrazoEntrega = padraoPrazoEntrega;
	}

	public Long getListaId() {
		return listaId;
	}

	public void setListaId(Long listaId) {
		this.listaId = listaId;
	}
	
	public static List<DetPrecosDto> converter(List<DetPrecos> dp) {
		return dp.stream().map(DetPrecosDto::new).collect(Collectors.toList());

	}

}
