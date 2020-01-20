package com.detalhe.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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

import com.detalhe.dto.ProteticoDto;
import com.detalhe.model.Protetico;
import com.detalhe.repository.ProteticoRepository;


@RestController
@RequestMapping("/proteticos")
public class ProteticoController {
	
	@Autowired
	ProteticoRepository proteticoRepository;

	@GetMapping
	public ResponseEntity<List<ProteticoDto>> listaProteticos() {
		List<Protetico> proteticos = this.proteticoRepository.listaProteticos();

		return ResponseEntity.ok(ProteticoDto.converter(proteticos));

	}

}
