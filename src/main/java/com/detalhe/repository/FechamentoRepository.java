package com.detalhe.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.detalhe.model.Clinica;
import com.detalhe.model.Fechamento;

public interface FechamentoRepository extends JpaRepository<Fechamento, Long> {
	
	public Optional<Fechamento> findById(Long id);
	
	@Query("SELECT f FROM Fechamento f WHERE f.valorTotal > f.valorPgto")
	public List<Fechamento> listaFechamentos();
	
	@Query("SELECT f FROM Fechamento f WHERE f.clinica = :clinica AND f.dataCad between :dataInicio and :dataFim")
	public List<Fechamento> consultaPorClinica(@Param("clinica") Clinica clinica, @Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

	@Query("SELECT f FROM Fechamento f WHERE f.dataCad between :dataInicio and :dataFim")
	public List<Fechamento> consultaPorMes(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
	
}
