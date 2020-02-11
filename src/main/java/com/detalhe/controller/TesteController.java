package com.detalhe.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.detalhe.model.Produto;
import com.detalhe.model.Tipo;
import com.detalhe.model.Pedido;
import com.detalhe.repository.ProdutoRepository;
import com.detalhe.repository.TipoRepository;
import com.detalhe.repository.PedidoRepository;


@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	TipoRepository tipoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository; 

	
	@GetMapping
	@RequestMapping("/getTipos")
	public ResponseEntity<List<Tipo>> getTipos(){
		List<Tipo> tipos = this.tipoRepository.findAll();
		
		return ResponseEntity.ok(tipos);
	}
	
	@GetMapping
	@RequestMapping("/getTipo")
	public ResponseEntity<Tipo> getTipo(){
		Tipo tipo = this.tipoRepository.findById(2L).get();
		
		return ResponseEntity.ok(tipo);
	}
	
	
	@GetMapping
	@RequestMapping("/getPedido")
	public ResponseEntity<Pedido> getPedido(){
		Long id = 5L;
		Pedido pedido = this.pedidoRepository.findById(id).get();
		
		return ResponseEntity.ok(pedido);
	}
	
	@GetMapping
	@RequestMapping("/getProduto")
	public ResponseEntity<Produto> getProduto(){
		Produto produto = this.produtoRepository.findById(2L).get();
		
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping
	@RequestMapping("/testeData")
	public ResponseEntity<LocalDateTime> testeData(){
		LocalDateTime ldt = LocalDateTime.now();
		return ResponseEntity.ok(ldt);
	}

}
