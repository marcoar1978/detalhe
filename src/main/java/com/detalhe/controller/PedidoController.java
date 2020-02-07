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

import com.detalhe.dto.AberturaPedidoDto;
import com.detalhe.dto.DentistaDto;
import com.detalhe.dto.ItemDto;
import com.detalhe.dto.PedidoDto;
import com.detalhe.form.PedidoObsForm;
import com.detalhe.model.Clinica;
import com.detalhe.model.Dentista;
import com.detalhe.model.Item;
import com.detalhe.model.Pedido;
import com.detalhe.model.Protetico;
import com.detalhe.model.StatusPedido;
import com.detalhe.model.Usuario;
import com.detalhe.repository.UsuarioRepository;
import com.detalhe.repository.ClinicaRepository;
import com.detalhe.repository.PedidoRepository;
import com.detalhe.repository.DentistaRepository;
import com.detalhe.repository.ItemRepository;
import com.detalhe.repository.ProteticoRepository;

import com.detalhe.service.Acesso;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ClinicaRepository clinicaRepository;

	@Autowired
	DentistaRepository dentistaRepository;

	@Autowired
	ProteticoRepository proteticoRepository;
	
	@Autowired
	ItemRepository itemRepository;

	@GetMapping
	@RequestMapping("/abrirPedido")
	@Transactional
	public ResponseEntity<AberturaPedidoDto> abrirPedido() {
		Pedido pedido = new Pedido();
		//ZoneId zid = ZoneId.of("America/Sao_Paulo");
		LocalDate hoje = LocalDate.now();
		//LocalDate datePrevista = hoje.plusDays(7);
		//pedido.setDataCad(hoje);
		//pedido.setDataPedido(hoje);
		//pedido.setDataEntregaPrevista(datePrevista);
		pedido.setUsuario(Acesso.getUsuario(usuarioRepository));
		Pedido pedidoAberto = this.pedidoRepository.save(pedido);
		
		AberturaPedidoDto aberturaPedidoDto = new AberturaPedidoDto();
		aberturaPedidoDto.setPedidoId(pedidoAberto.getId());
		aberturaPedidoDto.setDataPedido(hoje);
		return ResponseEntity.ok(aberturaPedidoDto);
	}

	@GetMapping
	@RequestMapping("/altClinica")
	@Transactional
	public ResponseEntity<?> altClinica(String pedidoIdForm, String clinicaIdForm) {
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Long clinicaId = Long.parseLong(clinicaIdForm);
		Clinica clinica = this.clinicaRepository.findById(clinicaId).get();
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		pedido.setClinica(clinica);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	@RequestMapping("/altDentista")
	@Transactional
	public void altDentista(String pedidoIdForm, String dentistaIdForm) {
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Long dentistaId = Long.parseLong(dentistaIdForm);
		Dentista dentista = this.dentistaRepository.findById(dentistaId).get();
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		pedido.setDentista(dentista);

	}

	@GetMapping
	@RequestMapping("/altNomePaciente")
	@Transactional
	public ResponseEntity<Pedido> altNomePaciente(String pedidoIdForm, String nomePaciente) {
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		pedido.setNomePaciente(nomePaciente);
		return ResponseEntity.ok(pedido);
	}

	@PostMapping
	@RequestMapping("/altObs")
	@Transactional
	public ResponseEntity<Long> altObs(@RequestBody PedidoObsForm pedidoObsForm) {
		Pedido pedido = this.pedidoRepository.getPedido(pedidoObsForm.getPedidoId());
		pedido.setObs(pedidoObsForm.getObs());
		return ResponseEntity.ok(1L);
	}

	@GetMapping
	@RequestMapping("/altProtetico")
	@Transactional
	public ResponseEntity<Pedido> altProtetico(String pedidoIdForm, String proteticoIdForm) {
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Long proteticoId = Long.parseLong(proteticoIdForm);
		Protetico protetico = this.proteticoRepository.getById(proteticoId).get();
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		pedido.setProtetico(protetico);

		return ResponseEntity.ok(pedido);
	}
	
	@GetMapping
	@RequestMapping("/altDataEntregaPrevista")
	@Transactional 
	public ResponseEntity<?> altDataEntregaPrevista(String pedidoIdForm, String diasASomarForm){
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Integer diasASomar = Integer.parseInt(diasASomarForm);
		LocalDate hoje = LocalDate.now();
		LocalDate dataPrevista = hoje.plusDays(diasASomar);
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		pedido.setDataEntregaPrevista(dataPrevista);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	@RequestMapping("/altDesconto")
	@Transactional 
	public ResponseEntity<?> altDesconto(String pedidoIdForm, String descontoForm){
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Integer desconto =  Integer.parseInt(descontoForm);
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		pedido.setDesconto(desconto);
			
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	@RequestMapping("/conferirPedido")
	@Transactional
	public ResponseEntity<PedidoDto> conferirPedido(String pedidoIdForm, String valorTotalForm, String valorLiquidoForm, String prazoForm){
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Double valorTotal = Double.parseDouble(valorTotalForm);
		Double valorLiquido = Double.parseDouble(valorLiquidoForm);
		Integer prazo = Integer.parseInt(prazoForm);
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		pedido.setValorTotal(valorTotal);
		pedido.setValorLiquido(valorLiquido);
		pedido.setPrazo(prazo);
		ZoneId zid = ZoneId.of("America/Sao_Paulo");
		LocalDate hoje = LocalDate.now(zid);
		LocalDate datePrevista = hoje.plusDays(prazo);
		pedido.setDataCad(hoje);
		pedido.setDataPedido(hoje);
		pedido.setDataEntregaPrevista(datePrevista);
				
		List<Item> itens = this.itemRepository.listaItemPorPedido(pedidoId);
		List<ItemDto> itemDto = ItemDto.converter(itens);
		
		PedidoDto pedidoDto = new PedidoDto(pedido, itemDto );
		
		return ResponseEntity.ok(pedidoDto);
	}
	
	@GetMapping
	@RequestMapping("/altDataPedido")
	@Transactional
	public ResponseEntity<?> altDataPedido(String pedidoIdForm, String dataPedidoForm, String prazoForm){
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Integer prazo = Integer.parseInt(prazoForm);
		String[] dataArray =  dataPedidoForm.split("-");
		Integer ano = Integer.parseInt(dataArray[0]);
		Integer mes = Integer.parseInt(dataArray[1]);
		Integer dia = Integer.parseInt(dataArray[2]);
		LocalDate dataPedido = LocalDate.of(ano, mes, dia);
		LocalDate dataEntregaPrevista = dataPedido.plusDays(prazo);
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		pedido.setDataPedido(dataPedido);
		pedido.setDataEntregaPrevista(dataEntregaPrevista);
			
		
		return ResponseEntity.ok().build();
	} 
	
	@GetMapping
	@RequestMapping("/fecharPedido")
	@Transactional
	public ResponseEntity<?> fecharPedido(String pedidoIdForm){
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		pedido.setStatusPedido(StatusPedido.EM_PROCESSO);
		
		return ResponseEntity.ok().build();
	}
	
	
	
}
