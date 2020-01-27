package com.detalhe.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.LigaClinicaProduto;
import com.detalhe.model.Produto;

public class LigaClinicaProdutoDto {
	
	private Long clinicaId;
	private Long produtoId;
	private String nome;
	private Double valor;
	private Integer padraoPrazoEntrega;
	
	public LigaClinicaProdutoDto(LigaClinicaProduto ligaClinicaProduto) {
		this.clinicaId = ligaClinicaProduto.getClinica().getId();
		this.produtoId = ligaClinicaProduto.getProduto().getId();
		this.nome = ligaClinicaProduto.getProduto().getNome();
		this.valor = ligaClinicaProduto.getValor();
		this.padraoPrazoEntrega = ligaClinicaProduto.getProduto().getPadraoPrazoEntrega();
			
	}

	public Long getClinicaId() {
		return clinicaId;
	}

	public void setClinicaId(Long clinicaId) {
		this.clinicaId = clinicaId;
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
	
	public static List<LigaClinicaProdutoDto> converter(List<LigaClinicaProduto> lcp) {
		return lcp.stream().map(LigaClinicaProdutoDto::new).collect(Collectors.toList());

	}

}
