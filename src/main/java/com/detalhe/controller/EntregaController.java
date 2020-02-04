package com.detalhe.controller;

import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.detalhe.repository.ClinicaRepository;
import com.detalhe.repository.PedidoRepository;
import com.detalhe.dto.ClinicaDto;
import com.detalhe.dto.Pedido2Dto;
import com.detalhe.model.Clinica;
import com.detalhe.model.Pedido;
import com.detalhe.model.StatusPedido;

@RestController
@RequestMapping("/processos")
public class EntregaController {
	
	@Autowired
	ClinicaRepository clinicaRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping
	@RequestMapping("/listaClinicasPorStatusPedidoEmProcesso")
	public ResponseEntity<List<ClinicaDto>> listaClinicasPorStatusPedidoEmProcesso(){
		
		List<Clinica> clinicas = this.clinicaRepository.listaClinicasPorStatusPedido(StatusPedido.EM_PROCESSO);
		return ResponseEntity.ok(ClinicaDto.converter(clinicas));
		
	}
	
	@GetMapping
	@RequestMapping("/listaPedidosPorStatusEmProcesso")
	public ResponseEntity<List<Pedido2Dto>> listaPedidosPorStatusEmProcesso(){
		List<Pedido> pedidos = this.pedidoRepository.listaPedidosPorStatus(StatusPedido.EM_PROCESSO);
		
		return ResponseEntity.ok(Pedido2Dto.converter(pedidos));
	}

}
