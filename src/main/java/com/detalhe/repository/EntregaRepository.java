package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.detalhe.model.Entrega;
import com.detalhe.model.StatusFechamento;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
	
	public Optional<Entrega> findById(Long id);
	
	@Query("SELECT e FROM Entrega e WHERE e.statusFechamento = :statusFechamento")
	public List<Entrega> listaEntregaPorStatus(@Param("statusFechamento") StatusFechamento statusFechamento);
	
	
	

}
