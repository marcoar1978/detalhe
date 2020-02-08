package com.detalhe.dto;

import java.time.LocalDate;

public class DadosIniciaisDto {
	
	private LocalDate dataHoje;
	private String nomeUsuario;
	
	public LocalDate getDataHoje() {
		return dataHoje;
	}
	public void setDataHoje(LocalDate dataHoje) {
		this.dataHoje = dataHoje;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
	

}

