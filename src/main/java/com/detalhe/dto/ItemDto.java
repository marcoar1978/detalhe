package com.detalhe.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.detalhe.model.Item;

public class ItemDto {
	
	private Long id;
	private String descricao;
	private Integer qde;
	private Double valorUnitario;
	private Double valorTotal;
	
	public ItemDto(Item item) {
		this.id = item.getId();
		this.descricao = item.getDescricao();
		this.qde = item.getQde();
		this.valorUnitario = item.getValorUnitario();
		this.valorTotal = item.getValorTotal();
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

	public Integer getQde() {
		return qde;
	}

	public void setQde(Integer qde) {
		this.qde = qde;
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
	
	public static List<ItemDto> converter(List<Item> itemPadrao) {
		return itemPadrao.stream().map(ItemDto::new).collect(Collectors.toList());

	}
}
