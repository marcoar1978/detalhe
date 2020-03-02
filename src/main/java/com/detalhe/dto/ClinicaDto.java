package com.detalhe.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Clinica;

public class ClinicaDto {

	private Long id;
	private String nomeSimp;
	private Long listaId;

	public ClinicaDto(Clinica clinica) {
		this.id = clinica.getId();
		this.nomeSimp = clinica.getNomeSimp();
		this.listaId = clinica.getListaPrecos().getId();
		
	}

	public Long getId() {
		return id;
	}

	public String getNomeSimp() {
		return nomeSimp;
	}
	
	public Long getListaId() {
		return listaId;
	}

	public void setListaId(Long listaId) {
		this.listaId = listaId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNomeSimp(String nomeSimp) {
		this.nomeSimp = nomeSimp;
	}

	public static List<ClinicaDto> converter(List<Clinica> clinicas) {
		return clinicas.stream().map(ClinicaDto::new).collect(Collectors.toList());

	}

}
