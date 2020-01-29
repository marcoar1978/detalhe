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
import com.detalhe.model.Tipo;
import com.detalhe.repository.PedidoRepository;
import com.detalhe.repository.ProdutoRepository;
import com.detalhe.repository.TipoRepository;
import com.detalhe.repository.ItemPadraoRepository;
import com.detalhe.repository.ItemVariavelRepository;
import com.detalhe.model.ItemPadrao;
import com.detalhe.model.ItemVariavel;
import com.detalhe.repository.ItemPadraoRepository;
import com.detalhe.dto.ItemPadraoDto;
import com.detalhe.dto.TipoVariavelDto;
import com.detalhe.form.AddItemPadraoForm;
import com.detalhe.form.AddItemVariavelForm;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ItemPadraoRepository itemPadraoRepository;

	@Autowired
	ItemVariavelRepository itemVariavelRepository;

	@Autowired
	TipoRepository tipoRepository;

	@PostMapping
	@RequestMapping("/addItemPadrao")
	@Transactional
	public ResponseEntity<?> addItemPadrao(@RequestBody AddItemPadraoForm addItemPadraoForm) {
		Produto produto = this.produtoRepository.findById(addItemPadraoForm.getProdutoId()).get();
		Pedido pedido = this.pedidoRepository.getPedido(addItemPadraoForm.getPedidoId());
		ItemPadrao itemPadrao = new ItemPadrao();
		itemPadrao.setPedido(pedido);
		itemPadrao.setProduto(produto);
		itemPadrao.setTipo(produto.getTipo());
		itemPadrao.setStatusEntrega(StatusEntrega.NAO);
		itemPadrao.setDataPedido(LocalDate.now());
		itemPadrao.setQde(addItemPadraoForm.getQdeProdutoPadrao());
		itemPadrao.setValorUnitario(addItemPadraoForm.getValorUnitario());
		itemPadrao.setValorTotal(addItemPadraoForm.getValorTotal());
		ItemPadrao itemPadraoSave = this.itemPadraoRepository.save(itemPadrao);
		List<ItemPadrao> listaItemPadraoPorPedido = this.itemPadraoRepository.listaItemPadraoPorPedido(pedido.getId());

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/delItemPadrao/{itemPadraoId}")
	@Transactional
	public ResponseEntity<?> delItemPadrao(@PathVariable Long itemPadraoId) {
		this.itemPadraoRepository.deleteById(itemPadraoId);

		return ResponseEntity.ok().build();

	}

	@PostMapping
	@RequestMapping("/addItemVariavel")
	@Transactional
	public ResponseEntity<?> addItemVariavel(@RequestBody AddItemVariavelForm addItemVariavelForm) {
		Pedido pedido = this.pedidoRepository.getPedido(addItemVariavelForm.getPedidoIdForm());
		Tipo tipo = this.tipoRepository.findById(addItemVariavelForm.getTipoIdForm()).get();
		ItemVariavel itemVariavel = new ItemVariavel();
		itemVariavel.setPedido(pedido);
		itemVariavel.setDescricao(addItemVariavelForm.getDescricaoForm());
		itemVariavel.setTipo(tipo);
		itemVariavel.setStatusEntrega(StatusEntrega.NAO);
		itemVariavel.setDataPedido(LocalDate.now());
		itemVariavel.setQde(addItemVariavelForm.getQdeForm());
		itemVariavel.setValorUnitario(addItemVariavelForm.getValorForm());
		itemVariavel.setValorTotal(addItemVariavelForm.getValorForm() * addItemVariavelForm.getQdeForm());

		this.itemVariavelRepository.save(itemVariavel);

		return ResponseEntity.ok().build();

	}

	@DeleteMapping("/delItemVariavel/{itemVariavelId}")
	@Transactional
	public ResponseEntity<?> delItemVariavel(@PathVariable Long itemVariavelId) {
		this.itemVariavelRepository.deleteById(itemVariavelId);

		return ResponseEntity.ok().build();

	}

	@GetMapping
	@RequestMapping("/listaTipoVariavel")
	public ResponseEntity<List<TipoVariavelDto>> listaTipoVariavel() {
		List<Tipo> tipos = this.tipoRepository.listaTipoVariavel();

		return ResponseEntity.ok(TipoVariavelDto.converter(tipos));

	}

}
