package com.detalhe.form;

public class AddItemForm {
	
	private Long pedidoId;
	private String uuid;
	private String tipoProduto;
	private Integer produtoId;
	private Integer ordem;
	private String descricao;
	private Double desconto;
	private Integer qde;
	private Double valorUnitario;
	private Double valorTotal;
		
	public Integer getProdutoId() {
		return produtoId;
	}

	public Long getPedidoId() {
		return pedidoId;
	}
	
	public String getTipoProduto() {
		return tipoProduto;
	}

	public Integer getOrdem() {
		return ordem;
	}
	public String getDescricao() {
		return descricao;
	}
	public Integer getQde() {
		return qde;
	}
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public Double getValorTotal() {
		return valorTotal;
	}

	public String getUuid() {
		return uuid;
	}

	public Double getDesconto() {
		return desconto;
	}
	
	

}
