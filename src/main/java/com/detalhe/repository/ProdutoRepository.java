package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.detalhe.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public Optional<Produto> findById(long id);
	
	@Query("SELECT p FROM Produto p ORDER BY p.nome")
	public List<Produto> listaProdutos();

}
