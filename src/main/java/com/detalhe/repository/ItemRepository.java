package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.detalhe.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	@Query("SELECT i FROM Item i WHERE i.pedido.id = :pedidoId and i.ordem = :ordem")
	public Item getItem(@Param("pedidoId") Long pedidoId, @Param("ordem") Integer ordem);
	
	@Query("SELECT i FROM Item i WHERE i.uuid = :uuid")
	public Item getItemUuid(@Param("uuid") String uuid);
	
	@Query("SELECT i FROM Item i WHERE i.pedido.id = :pedidoId")
	public List<Item> listaItemPorPedido(@Param("pedidoId") Long pedidoId);
	
	@Query("DELETE FROM Item i WHERE i.pedido.id = :pedidoId")
	public List<Item> delItensPorProduto(@Param("pedidoId") Long pedidoId);
	
	@Query("DELETE FROM Item i WHERE i.id = :itemId")
	public Item deleteItemById(@Param("itemId") Long itemId);
	
	@Query("SELECT i FROM Item i WHERE i.id = :itemId")
	public Item getItemById(@Param("itemId") Long itemId);
	
	public Optional<Item> findByUuid(String uuid);

}
