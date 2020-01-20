package com.detalhe.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Entity
public class Fechamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataFechamento;
	private Double valorTotal;

	@Enumerated
	private StatusEntrega pgto;

	@ManyToOne
	@JoinColumn(name = "clinica_id")
	private Clinica clinica;

	@ManyToOne
	@JoinColumn(name = "dentista_id")
	private Dentista dentista;

	private String obs;

	private LocalDate dataCad;
	private LocalDate dataAlt;

	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;

}
