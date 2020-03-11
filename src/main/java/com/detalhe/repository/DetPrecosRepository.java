package com.detalhe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.detalhe.model.DetPrecos;

public interface DetPrecosRepository extends JpaRepository<DetPrecos, Long> {
	
	@Query("SELECT dp FROM DetPrecos dp ORDER BY dp.produto.nome")
	public List<DetPrecos> detPrecos();

}
