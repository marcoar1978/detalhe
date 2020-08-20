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

import com.detalhe.model.Item;
import com.detalhe.model.Pedido;
import com.detalhe.model.Produto;
import com.detalhe.model.StatusEntrega;
import com.detalhe.model.StatusPedido;
import com.detalhe.model.Tipo;
import com.detalhe.model.TipoProduto;
import com.detalhe.repository.PedidoRepository;
import com.detalhe.repository.ProdutoRepository;
import com.detalhe.repository.TipoRepository;
import com.detalhe.repository.ItemRepository;
import com.detalhe.dto.TipoVariavelDto;
import com.detalhe.form.AddItemForm;
import com.detalhe.form.AddItemPadraoForm;
import com.detalhe.form.AddItemVariavelForm;
import com.detalhe.form.ObsForm;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	TipoRepository tipoRepository;

	@PostMapping
	@RequestMapping("/addItem")
	@Transactional
	public ResponseEntity<?> addItem(@RequestBody AddItemForm addItemForm) {
		Pedido pedido = this.pedidoRepository.getPedido(addItemForm.getPedidoId());

		Item item = new Item();
		item.setPedido(pedido);
		item.setDescricao(addItemForm.getDescricao());
		item.setOrdem(addItemForm.getOrdem());
		if (addItemForm.getTipoProduto().equals("padrao")) {
			item.setTipoProduto(TipoProduto.PADRAO);
		} else {
			item.setTipoProduto(TipoProduto.VARIAVEL);
		}
		item.setUuid(addItemForm.getUuid());
		item.setProdutoId(addItemForm.getProdutoId());
		item.setStatusEntrega(StatusEntrega.NAO);
		item.setStatusPedido(StatusPedido.EM_ABERTO);
		item.setDataPedido(LocalDate.now());
		item.setQde(addItemForm.getQde());
		item.setValorUnitario(addItemForm.getValorUnitario());
		item.setValorTotal(addItemForm.getValorUnitario() * addItemForm.getQde());

		this.itemRepository.save(item);

		return ResponseEntity.ok().build();

	}

	@GetMapping("/delItem")
	@Transactional
	public ResponseEntity<?> delItemVariavel(String uuid) {
		Item item = this.itemRepository.findByUuid(uuid).get();

		this.itemRepository.deleteById(item.getId());

		return ResponseEntity.ok().build();

	}

	@GetMapping
	@RequestMapping("/listaTipoVariavel")
	public ResponseEntity<List<TipoVariavelDto>> listaTipoVariavel() {
		List<Tipo> tipos = this.tipoRepository.listaTipoVariavel();
		return ResponseEntity.ok(TipoVariavelDto.converter(tipos));

	}
	
	@GetMapping
	@Transactional
	@RequestMapping("/altDescItem")
	public ResponseEntity<Item> altDescItem(String uuid, String desconto){
		Item item = this.itemRepository.findByUuid(uuid).get();
		item.setDesconto(Double.valueOf(desconto));
		return ResponseEntity.ok(item);
	}
	
	@PostMapping 
	@Transactional
	@RequestMapping("/altObs")
	public ResponseEntity<?> altObs(@RequestBody ObsForm obsForm){
		Item item = this.itemRepository.findByUuid(obsForm.getUuid()).get();
		item.setObs(obsForm.getObs());
		return ResponseEntity.ok().build();
		
	}
	
	
	
	

}
