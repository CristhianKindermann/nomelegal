package com.example.demo.rest;


import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.format.annotation.DateTimeFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.*;
import com.example.demo.model.repository.PedidoRepository;
import com.example.demo.model.repository.ProdutoRepository;

@CrossOrigin
@RestController
public class PedidoREST {
	
	@Autowired
	private PedidoRepository repo;
	@Autowired
	private ModelMapper mapper;
	
	public  List<PedidoDTO> pedidos = new ArrayList<>();
	public  List<ItemPedidoDTO> itensPedido = new ArrayList<>();
	
	
	@GetMapping("/pedidos")
	List<PedidoDTO> listarPedidos( @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(value = "fim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            @RequestParam(value= "id_cliente", required = false) Long id_cliente){

		List<Pedido> pedidos = repo.findAll();
		System.out.print(type);
		System.out.print(status);
		System.out.print(inicio);
		System.out.print(fim);
		System.out.print(id_cliente);
		
        if ("hoje".equals(type)) {
            LocalDate hoje = LocalDate.now();
            pedidos = repo.findByDataPedido(hoje);
        } else if ("todos".equals(type)) {
            pedidos = repo.findAll();
        } else if ("data".equals(type) && inicio != null && fim != null) {
            pedidos = repo.findByDataPedidoBetween(inicio, fim);
        }else if("status".equals(type) && status!= null && id_cliente == null) {
        	pedidos = repo.findByStatus(status);
        } else if ("status".equals(type) && status != null) {
            pedidos = repo.findByStatusAndPessoaId(status, id_cliente);
        } else {
            return null;
        }
		
        return pedidos.stream()
				.map(e -> mapper.map(e,
						PedidoDTO.class))
				.collect(Collectors.toList());
		
	}
	
	
	
	static {
		/*
		pedidos.add(new PedidoDTO(1,new ArrayList<>(), 150.00,"Em Aberto", LocalDate.parse("2023-10-10"), LocalDate.parse("2023-10-13"), 1));
		pedidos.add(new PedidoDTO(2,new ArrayList<>(), 100.00,"Em Aberto", LocalDate.parse("2023-09-30"), LocalDate.parse("2023-10-13"), 1));
		pedidos.add(new PedidoDTO(3,new ArrayList<>(), 50.00, "Cancelado", LocalDate.parse("2023-07-10"), LocalDate.parse("2023-10-13"), 2));
		pedidos.add(new PedidoDTO(4,new ArrayList<>(), 60.00, "Aguardando Pagamento", LocalDate.parse("2023-10-08"), LocalDate.parse("2023-10-13"), 2));
		pedidos.add(new PedidoDTO(5,new ArrayList<>(), 75.50, "Recolhido", LocalDate.parse("2023-09-30"), LocalDate.parse("2023-10-13"), 3));
		pedidos.add(new PedidoDTO(6,new ArrayList<>(), 30.00, "Finalizado", LocalDate.parse("2023-06-10"), LocalDate.parse("2023-10-13"), 4));
		pedidos.add(new PedidoDTO(7,new ArrayList<>(), 20.00, "Pago", LocalDate.parse("2023-07-10"), LocalDate.parse("2023-10-13"),5));
		*/
	}
	
	
	
}
