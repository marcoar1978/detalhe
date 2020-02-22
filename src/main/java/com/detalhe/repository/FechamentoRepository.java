package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.detalhe.model.Fechamento;

public interface FechamentoRepository extends JpaRepository<Fechamento, Long> {
	
	public Optional<Fechamento> findById(Long id);
	
	@Query("SELECT f FROM Fechamento f WHERE f.valorTotal > f.valorPgto")
	public List<Fechamento> listaFechamentos();

}
