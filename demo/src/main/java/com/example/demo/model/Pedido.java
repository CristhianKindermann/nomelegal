package com.example.demo.model;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import  org.springframework.format.annotation.DateTimeFormat;


public class Pedido implements Serializable{
	
	private int id;
	private static List<ItemPedido> produtos = new ArrayList<>();
	private double valorTotal;
	private String status;
	private LocalDate  data_pedido;
	private LocalDate  prazo_final;
	private int cliente;
	
	
	public Pedido() {
		super();
	}
	
	public Pedido(int id, List<ItemPedido> produtos, double valorTotal,String status, LocalDate data_pedido, LocalDate  prazo_final, int cliente) {
		super();
		this.id = id;
		this.produtos = produtos;
		this.valorTotal = valorTotal;
		this.status = status;
		this.data_pedido = data_pedido;
		this.prazo_final = prazo_final;
		this.cliente = cliente;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static List<ItemPedido> getProdutos() {
		return produtos;
	}
	public static void setProdutos(List<ItemPedido> produtos) {
		Pedido.produtos = produtos;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate  getData_pedido() {
		return data_pedido;
	}
	public void setData_pedido(LocalDate  data_pedido) {
		this.data_pedido = data_pedido;
	}
	public LocalDate  getPrazo_final() {
		return prazo_final;
	}
	public void setPrazo_final(LocalDate  prazo_final) {
		this.prazo_final = prazo_final;
	}
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

}
