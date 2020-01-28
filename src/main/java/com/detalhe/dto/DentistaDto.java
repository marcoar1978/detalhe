package com.detalhe.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Dentista;

public class DentistaDto {

	private Long id;
	
	private Long clinicaId;

	private String nome;

	public DentistaDto(Dentista dentista) {
		this.id = dentista.getId();
		this.clinicaId = dentista.getClinica().getId();
		this.nome = dentista.getNome();
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static List<DentistaDto> converter(List<Dentista> dentistas) {
		return dentistas.stream().map(DentistaDto::new).collect(Collectors.toList());

	}

}
