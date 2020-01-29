package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.detalhe.model.ItemPadrao;
import com.detalhe.model.Pedido;

public interface ItemPadraoRepository extends JpaRepository<ItemPadrao, Long> {

	public Optional<ItemPadrao> findById(Long id);

	@Query("SELECT i FROM ItemPadrao i WHERE i.pedido.id = :pedidoId")
	public List<ItemPadrao> listaItemPadraoPorPedido(@Param("pedidoId") Long pedidoId);
	
	@Query("SELECT i FROM ItemPadrao i WHERE i.pedido.id = :pedidoId and i.produto.id = :produtoId")
	public ItemPadrao getItemPorProduto(@Param("pedidoId") Long pedidoId, @Param("produtoId") Long produtoId);

}
