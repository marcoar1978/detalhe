package com.detalhe.controller;

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

import com.detalhe.dto.ProdutoDto;
import com.detalhe.model.Produto;
import com.detalhe.repository.ProdutoRepository;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository; 
	
	@GetMapping
	public ResponseEntity<List<ProdutoDto>> lista(){
		List<Produto> produtos = this.produtoRepository.listaProdutos();
		
		return ResponseEntity.ok(ProdutoDto.converter(produtos));
		
	}

}
