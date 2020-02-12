package com.detalhe.controller;

import java.time.LocalDate;
import java.time.ZoneId;
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

import com.detalhe.repository.ClinicaRepository;
import com.detalhe.repository.EntregaRepository;
import com.detalhe.repository.PedidoRepository;
import com.detalhe.repository.UsuarioRepository;
import com.detalhe.service.Acesso;
import com.detalhe.dto.ClinicaDto;
import com.detalhe.dto.EntregaDto;
import com.detalhe.dto.Pedido2Dto;
import com.detalhe.form.EntregaForm;
import com.detalhe.form.RecebimentoDto;
import com.detalhe.model.Clinica;
import com.detalhe.model.Entrega;
import com.detalhe.model.Pedido;
import com.detalhe.model.StatusFechamento;
import com.detalhe.model.StatusPedido;

@RestController
@RequestMapping("/processos")
public class EntregaController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ClinicaRepository clinicaRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	EntregaRepository entregaRepository;

	@GetMapping
	@RequestMapping("/listaClinicasPorStatusPedidoEmProcesso")
	public ResponseEntity<List<ClinicaDto>> listaClinicasPorStatusPedidoEmProcesso() {

		List<Clinica> clinicas = this.clinicaRepository.listaClinicasPorStatusPedido(StatusPedido.EM_PROCESSO);
		return ResponseEntity.ok(ClinicaDto.converter(clinicas));

	}

	@GetMapping
	@RequestMapping("/listaPedidosPorStatusEmProcesso")
	public ResponseEntity<List<Pedido2Dto>> listaPedidosPorStatusEmProcesso() {
		List<Pedido> pedidos = this.pedidoRepository.listaPedidosPorStatus(StatusPedido.EM_PROCESSO);

		return ResponseEntity.ok(Pedido2Dto.converter(pedidos));
	}

	@PostMapping
	@RequestMapping("/emiteEntrega")
	@Transactional
	public ResponseEntity<?> emiteRecebimento(@RequestBody EntregaForm entregaForm) {
		Entrega entrega = new Entrega();
		entrega.setDataCad(LocalDate.now().plusDays(1));
		Clinica clinica = this.clinicaRepository.findById(entregaForm.getClinicaId()).get();
		entrega.setClinica(clinica);
		entrega.setObs(entregaForm.getObs());
		entrega.setUsuario(Acesso.getUsuario(usuarioRepository));
		
		Entrega entregaSave = this.entregaRepository.save(entrega);
		
		for(int i = 0; i < entregaForm.getPedidosId().length; i++) {
			Pedido pedido = this.pedidoRepository.findById(entregaForm.getPedidosId()[i]).get();
			pedido.setStatusPedido(StatusPedido.CONCLUIDO);
			pedido.setEntrega(entregaSave);
			}
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping
	@RequestMapping("/registraRecebedor")
	@Transactional
	public ResponseEntity<?> registraRecebedor(@RequestBody RecebimentoDto recebimentoDto){
		Entrega entrega = this.entregaRepository.findById(recebimentoDto.getEntregaId()).get();
		entrega.setRecebedor(recebimentoDto.getRecebedor());
		entrega.setDataEntrega(recebimentoDto.getDataEntrega().plusDays(1));
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	@RequestMapping("/getEntregas")
	public ResponseEntity<EntregaDto> getEntregas(String entregaIdForm){
		Long entregaId = Long.parseLong(entregaIdForm);
		Entrega entrega = this.entregaRepository.findById(entregaId).get();
		
		EntregaDto entregaDto = new EntregaDto(entrega);
		
		return ResponseEntity.ok(entregaDto);
		
	}
	
	@GetMapping
	@RequestMapping("/listaEntregas")
	public ResponseEntity<?> listaEntregas(){
		List<Entrega> entregas = this.entregaRepository.listaEntregaPorStatus(StatusFechamento.NAO);
		return ResponseEntity.ok(EntregaDto.converter(entregas));
	}

}
