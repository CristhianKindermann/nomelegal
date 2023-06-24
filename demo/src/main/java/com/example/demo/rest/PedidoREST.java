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
	List<Pedido> listarPedidos(@RequestParam(required = false) String type_date,
								@RequestParam(required = false) String status,
								@RequestParam(required = false) String data_ini,
								@RequestParam(required = false) String data_fim){
		//System.out.print(status);
		
		if(status != null) { //pesquisa por tipo status pedido (tela de cliente)
			
			List<Pedido> pedidosHome = pedidos.stream().filter(pedido -> pedido.getStatus().equals(status)).collect(Collectors.toList());
			
			if (!pedidosHome.isEmpty()) {
				return pedidosHome;
			}

			return new ArrayList<>();
			
		}else if(type_date != null){  //pesquisa por tipo de range de data (tela de funcionario )
			
			
			if(type_date.equals("hoje")) {
				System.out.print(type_date);
				LocalDate dataAtual = LocalDate.now();
				
				System.out.println(dataAtual.getDayOfYear());
				List<Pedido> pedidosFiltrados = pedidos.stream().filter(pedido -> pedido.getData_pedido().isEqual(dataAtual)).toList();
				
				if(pedidosFiltrados != null) {
					return pedidosFiltrados;
				}
				return new ArrayList<>();
				

				
			}else if (type_date.equals("todos")){
				System.out.print("todos");
				return pedidos;
				
			}else if( type_date.equals("data")) {
				LocalDate dataInicio = LocalDate.parse(data_ini);
		        LocalDate dataFim = LocalDate.parse(data_fim);
		        System.out.print(data_ini);
		        System.out.print(data_fim);
				System.out.print("date");
				
				List<Pedido> pedidosFiltrados = pedidos.stream()
		                .filter(pedido -> pedido.getData_pedido().isAfter(dataInicio) && pedido.getData_pedido().isBefore(dataFim))
		                .collect(Collectors.toList());
				if (pedidosFiltrados != null) {
					return pedidosFiltrados;
				}
				
				return new ArrayList<>();
				
			}
			
		}
		
		return new ArrayList<>();
	}
	
	
	
	
	static {
		
		pedidos.add(new Pedido(1,new ArrayList<>(), 150.00,"Em Aberto", LocalDate.parse("2023-10-10"), LocalDate.parse("2023-10-13"), 1));
		pedidos.add(new Pedido(2,new ArrayList<>(), 100.00,"Em Aberto", LocalDate.parse("2023-09-30"), LocalDate.parse("2023-10-13"), 1));
		pedidos.add(new Pedido(3,new ArrayList<>(), 50.00, "Cancelado", LocalDate.parse("2023-07-10"), LocalDate.parse("2023-10-13"), 2));
		pedidos.add(new Pedido(4,new ArrayList<>(), 60.00, "Aguardando Pagamento", LocalDate.parse("2023-10-08"), LocalDate.parse("2023-10-13"), 2));
		pedidos.add(new Pedido(5,new ArrayList<>(), 75.50, "Recolhido", LocalDate.parse("2023-09-30"), LocalDate.parse("2023-10-13"), 3));
		pedidos.add(new Pedido(6,new ArrayList<>(), 30.00, "Finalizado", LocalDate.parse("2023-06-10"), LocalDate.parse("2023-10-13"), 4));
		pedidos.add(new Pedido(7,new ArrayList<>(), 20.00, "Pago",  LocalDate.now(), LocalDate.parse("2023-10-13"),5));
		
	}
	
	
	
}
