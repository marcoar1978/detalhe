package com.detalhe.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@ManyToOne
	@JoinColumn(name = "tipo_id")
	private Tipo tipo;

	private Double valor;
	
	private Integer padraoPrazoEntrega;

	private LocalDate dataCad;
	private LocalDate dataAlt;

	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;

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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getDataCad() {
		return dataCad;
	}

	public void setDataCad(LocalDate dataCad) {
		this.dataCad = dataCad;
	}

	public LocalDate getDataAlt() {
		return dataAlt;
	}

	public void setDataAlt(LocalDate dataAlt) {
		this.dataAlt = dataAlt;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getPadraoPrazoEntrega() {
		return padraoPrazoEntrega;
	}

	public void setPadraoPrazoEntrega(Integer padraoPrazoEntrega) {
		this.padraoPrazoEntrega = padraoPrazoEntrega;
	}
	

}
