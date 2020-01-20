package com.detalhe.controller;

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
import com.detalhe.model.ItemPadrao;
import com.detalhe.model.Pedido;
import com.detalhe.repository.ItemPadraoRepository;
import com.detalhe.repository.ProdutoRepository;
import com.detalhe.repository.TipoRepository;
import com.detalhe.repository.PedidoRepository;


@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	ItemPadraoRepository itemPadraoRepository;

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	TipoRepository tipoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository; 

	@GetMapping
	@RequestMapping("/addItemPadrao")
	@Transactional
	public ResponseEntity<Produto> addItemPadrao() {

		Produto produto = this.produtoRepository.findById(1l).get();

		ItemPadrao itemPadrao = new ItemPadrao();
		itemPadrao.setQde(2);
		itemPadrao.setValorUnitario(10.0);
		itemPadrao.setValorTotal(20.0);
		itemPadrao.setProduto(produto);

		this.itemPadraoRepository.save(itemPadrao);

		return ResponseEntity.ok(produto);
	}
	
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

}
