package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.detalhe.model.Clinica;

public interface ClinicaRepository extends JpaRepository<Clinica, Long>{
	
	@Query("Select clinica from Clinica clinica ORDER BY clinica.nomeSimp")
	public List<Clinica> listaClinicas();
	
	public Optional<Clinica> findById(Long id);
	

}
