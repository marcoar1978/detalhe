package com.detalhe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.detalhe.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	@Query("SELECT i FROM Item i WHERE i.pedido.id = :pedidoId and i.ordem = :ordem")
	public Item getItem(@Param("pedidoId") Long pedidoId, @Param("ordem") Integer ordem);
	
	@Query("SELECT i FROM Item i WHERE i.pedido.id = :pedidoId")
	public List<Item> listaItemPorPedido(@Param("pedidoId") Long pedidoId);

}
