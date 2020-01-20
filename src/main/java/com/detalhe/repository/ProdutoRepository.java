package com.detalhe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.detalhe.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public Optional<Produto> findById(long id);

}
