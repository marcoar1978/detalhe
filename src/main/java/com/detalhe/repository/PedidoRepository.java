package com.detalhe.repository;

import java.time.LocalDate;
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
	
	@Query("SELECT p FROM Pedido p WHERE p.nomePaciente LIKE %:nomePaciente% AND p.statusPedido NOT IN (:statusPedidoAberto, :statusPedidoCancelado)")
	public List<Pedido> consultaPorPaciente(@Param("nomePaciente") String nomePaciente, @Param("statusPedidoAberto") StatusPedido statusAberto, @Param("statusPedidoCancelado") StatusPedido statusFechado);
	
	@Query("SELECT p FROM Pedido p WHERE p.clinica = :clinica and p.dataPedido between :dataInicio and :dataFim  AND p.statusPedido NOT IN (:statusPedidoAberto, :statusPedidoCancelado)")
	public List<Pedido> consultaPorClinica(@Param("clinica") Clinica clinica, @Param("dataInicio") LocalDate dataInicio, @Param("dataFim")LocalDate dataFim,  @Param("statusPedidoAberto") StatusPedido statusAberto, @Param("statusPedidoCancelado") StatusPedido statusFechado);
	
	@Query("SELECT p FROM Pedido p WHERE p.dataPedido between :dataInicio and :dataFim  AND p.statusPedido NOT IN (:statusPedidoAberto, :statusPedidoCancelado)")
	public List<Pedido> consultaPorMes(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim")LocalDate dataFim, @Param("statusPedidoAberto") StatusPedido statusAberto, @Param("statusPedidoCancelado") StatusPedido statusFechado);
	
	@Query("SELECT p FROM Pedido p WHERE p.dataCad < :data AND p.statusPedido = :statusEmAberto")
	public List<Pedido> delPedidosEmAberto(@Param("data") LocalDate data, @Param("statusEmAberto") StatusPedido statusEmAberto);
	
	
	
	}
