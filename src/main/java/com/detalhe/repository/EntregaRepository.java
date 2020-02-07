package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.detalhe.model.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
	
	public Optional<Entrega> findById(Long id);
	
	
	

}
