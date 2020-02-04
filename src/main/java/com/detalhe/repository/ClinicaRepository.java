package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.detalhe.model.Clinica;
import com.detalhe.model.StatusPedido;

public interface ClinicaRepository extends JpaRepository<Clinica, Long>{
	
	@Query("Select clinica from Clinica clinica ORDER BY clinica.nomeSimp")
	public List<Clinica> listaClinicas();
	
	
	@Query("Select DISTINCT clinica from Clinica clinica LEFT JOIN clinica.pedidos pedido where pedido.statusPedido = :status")
	public List<Clinica> listaClinicasPorStatusPedido(@Param("status") StatusPedido status);
	
	public Optional<Clinica> findById(Long id);
	

}
