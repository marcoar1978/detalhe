package com.detalhe.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Clinica;
import com.detalhe.model.Produto;

public class ProdutoDto {

	private Long id;
	private String nome;
	private Double valor;
	private Integer padraoPrazoEntrega;

	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
		this.padraoPrazoEntrega = produto.getPadraoPrazoEntrega();
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

	public static List<ProdutoDto> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());

	}

}
