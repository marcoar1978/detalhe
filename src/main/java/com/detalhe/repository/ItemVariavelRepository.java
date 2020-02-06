package com.detalhe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.detalhe.model.ItemVariavel;

public interface ItemVariavelRepository extends JpaRepository<ItemVariavel, Long> {
	
	@Query("SELECT i FROM ItemVariavel i WHERE i.pedido.id = :pedidoId and i.ordem = :ordem")
	public ItemVariavel getItemVariavel(@Param("pedidoId") Long pedidoId, @Param("ordem") Integer ordem);

}
