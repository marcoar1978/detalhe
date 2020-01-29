package com.detalhe.form;

public class AddItemPadraoForm {

	private Long pedidoId;

	private Long produtoId;

	private Integer qdeProdutoPadrao;

	private Double valorUnitario;

	private Double valorTotal;

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public Integer getQdeProdutoPadrao() {
		return qdeProdutoPadrao;
	}

}
