package com.detalhe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.detalhe.dto.ClinicaDto;
import com.detalhe.model.Clinica;
import com.detalhe.repository.ClinicaRepository;

@RestController
@RequestMapping("clinicas")
public class ClinicaController {

	@Autowired
	ClinicaRepository clinicaRepository;

	@GetMapping
	public ResponseEntity<List<ClinicaDto>> lista() {
		List<Clinica> clinicas = this.clinicaRepository.listaClinicas();

		return ResponseEntity.ok(ClinicaDto.converter(clinicas));
	}

}
