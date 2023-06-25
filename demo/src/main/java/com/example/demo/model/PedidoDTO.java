package com.example.demo.model;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import  org.springframework.format.annotation.DateTimeFormat;


public class PedidoDTO implements Serializable{
	
	private int id;
	//private List<ItemPedidoDTO> produtos = new ArrayList<>();
	private double valorTotal;
	private String status;
	private LocalDate data_pedido;
	private LocalDate data_prazo;
	private Long fk_pessoa_id;
	
	
	public PedidoDTO() {
		super();
	}
	
	public PedidoDTO(int id,  double valorTotal,String status , LocalDate data_pedido, LocalDate data_prazo, Long fk_pessoa_id ) {
		super();
		this.id = id;
		//this.produtos = produtos;
		this.valorTotal = valorTotal;
		this.status = status;
		this.data_pedido = data_pedido;
		this.data_prazo = data_prazo;
		this.fk_pessoa_id = fk_pessoa_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*
	public List<ItemPedidoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ItemPedidoDTO> produtos) {
		this.produtos = produtos;
	}
	
	*/
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
		return data_prazo;
	}
	public void setPrazo_final(LocalDate  prazo_final) {
		this.data_prazo = prazo_final;
	}
	
	public Long getCliente() {
		return fk_pessoa_id;
	}
	
	public void setCliente(Long cliente) {
		this.fk_pessoa_id = cliente;
	}
	
	

}
