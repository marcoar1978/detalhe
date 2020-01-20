package com.detalhe.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Dentista;
import com.detalhe.model.Protetico;

public class ProteticoDto {
	
	private Long id;
	
	private String nome;
	
	public ProteticoDto(Protetico protetico) {
		this.id = protetico.getId();
		
		this.nome = protetico.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public static List<ProteticoDto> converter(List<Protetico> dentistas) {
		return dentistas.stream().map(ProteticoDto::new).collect(Collectors.toList());

	}

}
