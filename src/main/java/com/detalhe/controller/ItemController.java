package com.detalhe.controller;

import java.time.LocalDate;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.detalhe.model.Pedido;
import com.detalhe.model.Produto;
import com.detalhe.model.StatusEntrega;
import com.detalhe.repository.PedidoRepository;
import com.detalhe.repository.ProdutoRepository;
import com.detalhe.repository.ItemPadraoRepository;
import com.detalhe.model.ItemPadrao;
import com.detalhe.repository.ItemPadraoRepository;
import com.detalhe.dto.ItemPadraoDto;
import com.detalhe.form.AddItemPadraoForm;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ItemPadraoRepository itemPadraoRepository;

	@PostMapping
	@RequestMapping("/addItemPadrao")
	@Transactional
	public ResponseEntity<List<ItemPadraoDto>> addItemPadrao(@RequestBody AddItemPadraoForm addItemPadraoForm) {
		Produto produto = this.produtoRepository.findById(addItemPadraoForm.getProdutoId()).get();
		Pedido pedido = this.pedidoRepository.getPedido(addItemPadraoForm.getPedidoId());
		ItemPadrao itemPadrao = new ItemPadrao();
		itemPadrao.setPedido(pedido);
		itemPadrao.setProduto(produto);
		itemPadrao.setTipo(produto.getTipo());
		itemPadrao.setStatusEntrega(StatusEntrega.NAO);
		itemPadrao.setDataPedido(LocalDate.now());
		itemPadrao.setQde(addItemPadraoForm.getQdeProdutoPadrao());
		itemPadrao.setValorUnitario(produto.getValor());
		itemPadrao.setValorTotal(produto.getValor() * addItemPadraoForm.getQdeProdutoPadrao());
		ItemPadrao itemPadraoSave = this.itemPadraoRepository.save(itemPadrao);
		List<ItemPadrao> listaItemPadraoPorPedido = this.itemPadraoRepository.listaItemPadraoPorPedido(pedido.getId());

		return ResponseEntity.ok(ItemPadraoDto.converter(listaItemPadraoPorPedido));
	}
	
	@DeleteMapping("/delItemPadrao/{itemPadraoId}")
	@Transactional
	public ResponseEntity<?> delItemPadrao(@PathVariable Long itemPadraoId){
		this.itemPadraoRepository.deleteById(itemPadraoId);
		
		return ResponseEntity.ok().build();
		
	}

}
