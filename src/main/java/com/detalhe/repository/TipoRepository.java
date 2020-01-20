package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.detalhe.model.Tipo;;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
	
	public Optional<Tipo> findById(long id);
	
	@Query("SELECT t FROM Tipo t WHERE t.categoriatipo = 1")
	public List<Tipo> listaTipoVariavel();

}
