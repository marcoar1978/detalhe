package com.detalhe.controller;

import java.time.LocalDate;

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

import com.detalhe.dto.DadosIniciaisDto;
import com.detalhe.model.Usuario;
import com.detalhe.repository.UsuarioRepository;
import com.detalhe.service.Acesso;

@RestController
@RequestMapping("/dadosIniciais")
public class InicioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping
	@RequestMapping("/dataEUsuario")
	public ResponseEntity<DadosIniciaisDto> dataEUsuario(){
		DadosIniciaisDto dadosIniciaisDto = new DadosIniciaisDto();
		dadosIniciaisDto.setDataHoje(LocalDate.now());
		Usuario usuario = Acesso.getUsuario(usuarioRepository);
		dadosIniciaisDto.setNomeUsuario(usuario.getNome());
		
		return ResponseEntity.ok(dadosIniciaisDto);
	}

}
