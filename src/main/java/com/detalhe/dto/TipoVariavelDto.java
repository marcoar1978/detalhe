package com.detalhe.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Clinica;
import com.detalhe.model.Tipo;

public class TipoVariavelDto {
	
	private Long id;
	private String nome;
	
	public TipoVariavelDto(Tipo tipo) {
		this.id = tipo.getId();
		this.nome = tipo.getNome();
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
	
	public static List<TipoVariavelDto> converter(List<Tipo> tiposVariavel) {
		return tiposVariavel.stream().map(TipoVariavelDto::new).collect(Collectors.toList());

	}
	
	

}
