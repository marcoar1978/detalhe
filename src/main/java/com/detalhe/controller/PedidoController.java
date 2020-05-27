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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.detalhe.dto.AberturaPedidoDto;
import com.detalhe.dto.DentistaDto;
import com.detalhe.dto.ItemDto;
import com.detalhe.dto.Pedido2Dto;
import com.detalhe.dto.PedidoDto;
import com.detalhe.form.FinalizarPedidoForm;
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
import com.detalhe.service.Data;

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
		LocalDate hoje = LocalDate.now();
		pedido.setDataCad(hoje);
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
	public ResponseEntity<?> altDataEntregaPrevista(String pedidoIdForm, String diasASomarForm) {
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
	public ResponseEntity<?> altDesconto(String pedidoIdForm, String descontoForm) {
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Integer desconto = Integer.parseInt(descontoForm);
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		pedido.setDesconto(desconto);

		return ResponseEntity.ok().build();
	}

	@PostMapping
	@RequestMapping("/conferirPedido")
	@Transactional
	public ResponseEntity<PedidoDto> conferirPedido(@RequestBody FinalizarPedidoForm form) {
		Pedido pedido = this.pedidoRepository.getPedido(form.getPedidoId());
		Clinica clinica = this.clinicaRepository.findById(form.getClinicaId()).get();
		Dentista dentista = this.dentistaRepository.findById(form.getDentistaId()).get();
		Protetico protetico = this.proteticoRepository.getById(form.getProteticoId()).get();
		pedido.setClinica(clinica);
		pedido.setDentista(dentista);
		pedido.setProtetico(protetico);
		pedido.setNomePaciente(form.getNomePaciente());
		pedido.setProtetico(protetico);
		pedido.setDesconto(form.getDesconto());
		pedido.setDataCad(LocalDate.now().plusDays(1));
		pedido.setDataPedido(form.getDataPedido().plusDays(1));
		pedido.setObs(form.getObs());
		pedido.setPrazo(form.getPrazo());
		pedido.setDataEntregaPrevista(pedido.getDataPedido().plusDays(form.getPrazo()));
		pedido.setDesconto(form.getDesconto());
		pedido.setValorTotal(form.getValorTotal());
		pedido.setValorLiquido(form.getValorLiquido());
		pedido.setStatusPedido(StatusPedido.EM_PROCESSO);

		List<Item> itens = this.itemRepository.listaItemPorPedido(form.getPedidoId());
		List<ItemDto> itemDto = ItemDto.converter(itens);

		Pedido pedidoSave = this.pedidoRepository.getPedido(pedido.getId());

		PedidoDto pedidoDto = new PedidoDto(pedidoSave, itemDto);

		return ResponseEntity.ok(pedidoDto);
	}

	@GetMapping
	@RequestMapping("/altDataPedido")
	@Transactional
	public ResponseEntity<?> altDataPedido(String pedidoIdForm, String dataPedidoForm, String prazoForm) {
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Integer prazo = Integer.parseInt(prazoForm);
		String[] dataArray = dataPedidoForm.split("-");
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
	public ResponseEntity<?> fecharPedido(String pedidoIdForm) {
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		pedido.setStatusPedido(StatusPedido.EM_PROCESSO);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	@RequestMapping("/cancelarPedido")
	@Transactional
	public ResponseEntity<?> cancelarPedido(String pedidoIdForm) {
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		pedido.setStatusPedido(StatusPedido.CANCELADO);
		return ResponseEntity.ok().build();

	}
	
	@GetMapping
	@RequestMapping("/delPedidosEmAberto")
	public ResponseEntity<List<Pedido2Dto>> delPedidosEmAberto(){
		LocalDate data = LocalDate.now().minusDays(2);
		System.out.println(data);
		List<Pedido> pedidos = this.pedidoRepository.delPedidosEmAberto(data, StatusPedido.EM_ABERTO);
		
		return ResponseEntity.ok(Pedido2Dto.converter(pedidos));
	}
	

	@GetMapping
	@RequestMapping("/delItensPorProduto")
	@Transactional
	public ResponseEntity<?> delItensPorProduto(String pedidoIdForm) {
		Long pedidoId = Long.parseLong(pedidoIdForm);
		List<Item> itens = this.itemRepository.listaItemPorPedido(pedidoId);
		for (Item item : itens) {
			this.itemRepository.deleteById(item.getId());
		}

		return ResponseEntity.ok().build();
	}

	@GetMapping
	@RequestMapping("/consultaPorId/{pedidoIdForm}")
	public ResponseEntity<Pedido2Dto> consultaPorId(@PathVariable String pedidoIdForm) {
		Long pedidoId = Long.parseLong(pedidoIdForm);
		Pedido pedido = this.pedidoRepository.getPedido(pedidoId);
		if (pedido == null) {
			return ResponseEntity.badRequest().build();
		} else {
			Pedido2Dto pedido2Dto = new Pedido2Dto(pedido);
			return ResponseEntity.ok(pedido2Dto);
		}

	}

	@GetMapping
	@RequestMapping("/consultaPorPaciente")
	public ResponseEntity<List<Pedido2Dto>> consultaPorPaciente(String nomePaciente) {
		List<Pedido> pedidos = this.pedidoRepository.consultaPorPaciente(nomePaciente, StatusPedido.EM_ABERTO,
				StatusPedido.CANCELADO);
		return ResponseEntity.ok(Pedido2Dto.converter(pedidos));
	}

	@GetMapping
	@RequestMapping("/consultaPorClinica")
	public ResponseEntity<List<Pedido2Dto>> consultaPorClinica(String clinicaIdForm, String anoForm, String mesForm) {

		Integer ano = Integer.parseInt(anoForm);
		Integer mes = Integer.parseInt(mesForm);
		LocalDate dataInicio = LocalDate.of(ano, mes, 1);
		LocalDate dataFim = Data.getDataFim(ano, mes);
		List<Pedido> pedidos = null;
		if (clinicaIdForm.equals("todos")) {
			pedidos = this.pedidoRepository.consultaPorMes(dataInicio, dataFim, StatusPedido.EM_ABERTO,
					StatusPedido.CANCELADO);
		} else {
			Long clinicaId = Long.parseLong(clinicaIdForm);
			Clinica clinica = this.clinicaRepository.findById(clinicaId).get();
			pedidos = this.pedidoRepository.consultaPorClinica(clinica, dataInicio, dataFim, StatusPedido.EM_ABERTO,
					StatusPedido.CANCELADO);
		}

		return ResponseEntity.ok(Pedido2Dto.converter(pedidos));
	}
	
	@GetMapping
	@RequestMapping("/delPedidoEmAberto")
	@Transactional
	public ResponseEntity<?> delPedidoEmAberto(){
		LocalDate data = LocalDate.now().minusDays(2);
		List<Pedido> pedidos = this.pedidoRepository.delPedidosEmAberto(data, StatusPedido.EM_ABERTO);
		for(int i = 0; i < pedidos.size(); i++) {
			Pedido pedido = this.pedidoRepository.getPedido(pedidos.get(i).getId());
			this.pedidoRepository.deleteById(pedido.getId());
			}
		return ResponseEntity.ok().build();
		
	}
	

}
