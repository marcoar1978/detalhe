package com.detalhe.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Clinica;

public class ClinicaDto {

	private Long id;
	private String nomeSimp;

	public ClinicaDto(Clinica clinica) {
		this.id = clinica.getId();
		this.nomeSimp = clinica.getNomeSimp();
	}

	public Long getId() {
		return id;
	}

	public String getNomeSimp() {
		return nomeSimp;
	}

	public static List<ClinicaDto> converter(List<Clinica> clinicas) {
		return clinicas.stream().map(ClinicaDto::new).collect(Collectors.toList());

	}

}
