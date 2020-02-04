package com.detalhe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.detalhe.model.Clinica;
import com.detalhe.model.Pedido;
import com.detalhe.model.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	public Optional<Pedido> findById(Long id);
	
	@Query("Select p from Pedido p where p.id = :pedidoId")
	public Pedido getPedido(@Param("pedidoId") Long pedidoId);
	
	@Query("SELECT p FROM Pedido p WHERE p.statusPedido = :status")
	public List<Pedido> listaPedidosPorStatus(@Param("status") StatusPedido status);
	
	}
