package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.detalhe.model.Clinica;
import com.detalhe.model.Dentista;;

public interface DentistaRepository extends JpaRepository<Dentista, Long> {
	
	@Query("SELECT d FROM Dentista d where d.clinica = :clinica ORDER BY d.nome")
	public List<Dentista> listaDentistas(@Param("clinica") Clinica clinica);
	
	public Optional<Dentista> findById(Long id);

}
