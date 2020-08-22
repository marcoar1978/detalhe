package com.detalhe.controller;

import java.util.List;
import java.util.Optional;
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
import com.detalhe.model.Clinica;
import com.detalhe.model.Fechamento;
import com.detalhe.model.Pgto;
import com.detalhe.form.AddPgtoForm;
import com.detalhe.repository.ClinicaRepository;
import com.detalhe.repository.FechamentoRepository;
import com.detalhe.repository.PgtoRepository;
import com.detalhe.repository.UsuarioRepository;
import com.detalhe.service.Acesso;
import com.detalhe.service.Data;

@RestController
@RequestMapping("/fechamento")
public class FechamentoController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ClinicaRepository clinicaRepository;

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
	public ResponseEntity<?> addPgto(@RequestBody AddPgtoForm addPgtoForm) {
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
	public ResponseEntity<FechamentoDto> getFechamento(@PathVariable String fechamentoIdForm) {
		Long fechamentoId = Long.valueOf(fechamentoIdForm);
		Optional<Fechamento> fechamentoOptional = this.fechamentoRepository.findById(fechamentoId);
		if (fechamentoOptional.isPresent()) {
			FechamentoDto fechamentoDto = new FechamentoDto(fechamentoOptional.get());
			return ResponseEntity.ok(fechamentoDto);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@GetMapping
	@RequestMapping("/consultaPorClinica")
	public ResponseEntity<List<FechamentoDto>> consultaPorClinica(String clinicaIdForm, String anoForm,
			String mesForm) {
		Integer ano = Integer.parseInt(anoForm);
		Integer mes = Integer.parseInt(mesForm);
		LocalDate dataInicio = LocalDate.of(ano, mes, 1);
		LocalDate dataFim = Data.getDataFim(ano, mes);
		List<Fechamento> fechamentos = null;
		if (clinicaIdForm.equals("todos")) {
			fechamentos = this.fechamentoRepository.consultaPorMes(dataInicio, dataFim);
		} else {
			Long clinicaId = Long.parseLong(clinicaIdForm);
			Clinica clinica = this.clinicaRepository.findById(clinicaId).get();
			fechamentos = this.fechamentoRepository.consultaPorClinica(clinica, dataInicio, dataFim);
		}

		return ResponseEntity.ok(FechamentoDto.converter(fechamentos));
	}
	
	@GetMapping
	@RequestMapping("/addDesconto")
	@Transactional
	public ResponseEntity<?> addDesconto(String fechamentoId, String desconto){
		Fechamento fechamento = this.fechamentoRepository.findById(Long.valueOf(fechamentoId)).get();
		fechamento.setDesconto(Double.valueOf(desconto));
		Double valorLiquido = fechamento.getValorFechamento() - Double.valueOf(desconto);
		fechamento.setValorTotal(valorLiquido);
		return ResponseEntity.ok().build();
	}

}
