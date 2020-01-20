package com.detalhe.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Dentista;
import com.detalhe.model.ItemPadrao;

public class ItemPadraoDto {
	
	private Long id;
	private String descricao;
	private Double valorUnitario;
	private Double valorTotal;
	
	public ItemPadraoDto(ItemPadrao itemPadrao) {
		this.id = itemPadrao.getId();
		this.descricao = itemPadrao.getProduto().getNome();
		this.valorUnitario = itemPadrao.getValorUnitario();
		this.valorTotal = itemPadrao.getValorTotal();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public static List<ItemPadraoDto> converter(List<ItemPadrao> itemPadrao) {
		return itemPadrao.stream().map(ItemPadraoDto::new).collect(Collectors.toList());

	}

}
