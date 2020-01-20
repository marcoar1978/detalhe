package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.detalhe.model.Protetico;;

public interface ProteticoRepository extends JpaRepository<Protetico, Long> {
	
	@Query("SELECT p FROM Protetico p ORDER BY p.nome")
	public List<Protetico> listaProteticos();
	
	@Query("SELECT p FROM Protetico p WHERE p.id = :proteticoId")
	public Optional<Protetico> getById(@Param("proteticoId") Long ProteticoId);
}
