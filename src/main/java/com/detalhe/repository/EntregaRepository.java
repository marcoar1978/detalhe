package com.detalhe.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.detalhe.model.Clinica;
import com.detalhe.model.Entrega;
import com.detalhe.model.StatusFechamento;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
	
	public Optional<Entrega> findById(Long id);
		
	@Query("SELECT e FROM Entrega e WHERE e.statusFechamento = :statusFechamento")
	public List<Entrega> listaEntregaPorStatus(@Param("statusFechamento") StatusFechamento statusFechamento);
	
	@Query("SELECT e FROM Entrega e WHERE e.clinica = :clinica AND e.dataCad between :dataInicio and :dataFim")
	public List<Entrega> listaEntregaPorClinica(@Param("clinica") Clinica clinica, @Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
	
	@Query("SELECT e FROM Entrega e WHERE e.dataCad between :dataInicio and :dataFim")
	public List<Entrega> listaEntregaPorMes(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
}
