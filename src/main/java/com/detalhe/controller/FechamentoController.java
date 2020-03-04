package com.detalhe.controller;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.detalhe.dto.FechamentoDto;
import com.detalhe.model.Fechamento;
import com.detalhe.model.Pgto;
import com.detalhe.form.AddPgtoForm;
import com.detalhe.repository.FechamentoRepository;
import com.detalhe.repository.PgtoRepository;
import com.detalhe.repository.UsuarioRepository;
import com.detalhe.service.Acesso;

@RestController
@RequestMapping("/fechamento")
public class FechamentoController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PgtoRepository pgtoRepository;

	@Autowired
	FechamentoRepository fechamentoRepository;

	@GetMapping
	@RequestMapping("/lista")
	public ResponseEntity<List<FechamentoDto>> listaFechamentos() {
		List<Fechamento> fechamentos = this.fechamentoRepository.listaFechamentos();
		List<FechamentoDto> fechamentosDto = FechamentoDto.converter(fechamentos);
		return ResponseEntity.ok(fechamentosDto);

	}
	
	@PostMapping
	@RequestMapping("/addPgto")
	@Transactional
	public ResponseEntity<?> addPgto(@RequestBody AddPgtoForm addPgtoForm){
		Fechamento fechamento = this.fechamentoRepository.findById(addPgtoForm.getFechamentoId()).get();
		Double valorPgtoAtual = addPgtoForm.getValor() + fechamento.getValorPgto();
		fechamento.setValorPgto(valorPgtoAtual);
		
		Pgto pgto = new Pgto();
		pgto.setFechamento(fechamento);
		pgto.setDataCad(LocalDate.now().plusDays(1));
		pgto.setDataPagamento(addPgtoForm.getDataPagamento().plusDays(1));
		pgto.setValor(addPgtoForm.getValor());
		pgto.setObs(addPgtoForm.getObs());
		pgto.setUsuario(Acesso.getUsuario(usuarioRepository));
		
		this.pgtoRepository.save(pgto);
			
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{fechamentoIdForm}")
	public ResponseEntity<FechamentoDto> getFechamento(@PathVariable String fechamentoIdForm){
		Long fechamentoId = Long.valueOf(fechamentoIdForm);
		Fechamento fechamento = this.fechamentoRepository.findById(fechamentoId).get();
		FechamentoDto fechamentoDto = new FechamentoDto(fechamento);
		
		return ResponseEntity.ok(fechamentoDto);
	}
	

}
