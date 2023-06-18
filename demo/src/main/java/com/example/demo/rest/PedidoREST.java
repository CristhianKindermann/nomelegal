package com.example.demo.rest;


import java.time.LocalDate;
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

@CrossOrigin
@RestController
public class PedidoREST {
	public static List<Pedido> pedidos = new ArrayList<>();
	public static List<ItemPedido> itensPedido = new ArrayList<>();
	
	@GetMapping("/pedidos")
	List<Pedido> listarPedidos(@RequestParam(required = false) String type){
		System.out.print(type);
		if(type != null) {
			List<Pedido> pedidosHome = pedidos.stream().filter(pedido -> pedido.getStatus().equals(type)).collect(Collectors.toList());
			
			if (!pedidosHome.isEmpty()) {
				return pedidosHome;
			}
			
			return null;
		}
		
		return pedidos;
	}
	

	
	
	static {
		
		pedidos.add(new Pedido(1,new ArrayList<>(), 150.00,"Em Aberto", LocalDate.parse("2023-10-10"), LocalDate.parse("2023-10-13"), 1));
		pedidos.add(new Pedido(2,new ArrayList<>(), 100.00,"Em Aberto", LocalDate.parse("2023-09-30"), LocalDate.parse("2023-10-13"), 1));
		pedidos.add(new Pedido(3,new ArrayList<>(), 50.00, "Cancelado", LocalDate.parse("2023-07-10"), LocalDate.parse("2023-10-13"), 2));
		pedidos.add(new Pedido(4,new ArrayList<>(), 60.00, "Aguardando Pagamento", LocalDate.parse("2023-10-08"), LocalDate.parse("2023-10-13"), 2));
		pedidos.add(new Pedido(5,new ArrayList<>(), 75.50, "Recolhido", LocalDate.parse("2023-09-30"), LocalDate.parse("2023-10-13"), 3));
		pedidos.add(new Pedido(6,new ArrayList<>(), 30.00, "Finalizado", LocalDate.parse("2023-06-10"), LocalDate.parse("2023-10-13"), 4));
		pedidos.add(new Pedido(7,new ArrayList<>(), 20.00, "Pago", LocalDate.parse("2023-07-10"), LocalDate.parse("2023-10-13"),5));
		
		
		/*
		 * 
		 
		 private int id;
			private static List<ItemPedido> produtos = new ArrayList<>();
			private double valorTotal;
			private String status;
			private Date data_pedido;
			private Date prazo_final;
			private int cliente;
		 
		itensPedido.add(new ItemPedido(1,"camisa", 15.6, 2, 3));
		itensPedido.add(new ItemPedido(1,"camisa", 15.6, 2, 3 ));
		itensPedido.add(new ItemPedido(1,"camisa", 15.6, 2, 3 ));
		itensPedido.add(new ItemPedido(1,"camisa", 15.6, 2, 3 ));
		itensPedido.add(new ItemPedido(1,"camisa", 15.6, 2, 3 ));
		itensPedido.add(new ItemPedido(1,"camisa", 15.6, 2, 3 ));
		
		
		
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.prazo = prazo;
		this.quantidade = quantidade;
		*/
		
		
		
		
		
	}
	
	
	
}
