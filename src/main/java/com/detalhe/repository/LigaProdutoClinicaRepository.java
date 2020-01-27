package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.detalhe.model.LigaClinicaProduto;

public interface LigaProdutoClinicaRepository extends JpaRepository<LigaClinicaProduto, Long> {
	
	@Query("SELECT lcp FROM LigaClinicaProduto lcp WHERE lcp.clinica.id = :clinicaId")
	public List<LigaClinicaProduto> listaPorClinica(Long clinicaId);
	
	

}
