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

import com.detalhe.dto.FechamentoDto;
import com.detalhe.model.Fechamento;
import com.detalhe.repository.FechamentoRepository;

@RestController
@RequestMapping("/fechamento")
public class FechamentoController {

	@Autowired
	FechamentoRepository fechamentoRepository;

	@GetMapping
	@RequestMapping("/lista")
	public ResponseEntity<List<FechamentoDto>> listaFechamentos() {
		List<Fechamento> fechamentos = this.fechamentoRepository.listaFechamentos();
		List<FechamentoDto> fechamentosDto = FechamentoDto.converter(fechamentos);
		return ResponseEntity.ok(fechamentosDto);

	}

}
