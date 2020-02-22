package com.detalhe.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Pgto;
import com.detalhe.model.Produto;

public class PgtoDto {

	private Long id;
	private LocalDate dataPagamento;
	private Double valor;
	private String obs;
	private String usuario;
	

	public PgtoDto(Pgto pgto) {
		this.id = pgto.getId();
		this.dataPagamento = pgto.getDataPagamento();
		this.valor = pgto.getValor();
		this.obs = pgto.getObs();
		this.usuario = pgto.getUsuario().getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public static List<PgtoDto> converter(List<Pgto> pgtos) {
		return pgtos.stream().map(PgtoDto::new).collect(Collectors.toList());
	}

}
