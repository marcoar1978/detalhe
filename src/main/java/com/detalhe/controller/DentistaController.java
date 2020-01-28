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

import com.detalhe.dto.DentistaDto;
import com.detalhe.form.PedidoObsForm;
import com.detalhe.model.Clinica;
import com.detalhe.model.Dentista;
import com.detalhe.model.Pedido;
import com.detalhe.model.Protetico;
import com.detalhe.model.Usuario;
import com.detalhe.repository.UsuarioRepository;
import com.detalhe.repository.ClinicaRepository;
import com.detalhe.repository.PedidoRepository;
import com.detalhe.repository.DentistaRepository;
import com.detalhe.repository.ProteticoRepository;

@RestController
@RequestMapping("/dentista")
public class DentistaController {
	
	@Autowired
	DentistaRepository dentistaRepository;
	
	@GetMapping
	public ResponseEntity<List<DentistaDto>> lista(){
		List<Dentista> dentistas = this.dentistaRepository.listaDentistas();
		return ResponseEntity.ok(DentistaDto.converter(dentistas));
	}

}
