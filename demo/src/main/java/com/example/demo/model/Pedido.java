package com.example.demo.model;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import  org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name="pedido")
public class Pedido implements Serializable{
	
	private static final Long
	serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	//@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<ItemPedido> produtos = new ArrayList<>();
	
	//private static List<ItemPedidoDTO> produtos = new ArrayList<>();
	@Transient
	private double valorTotal;
	
	@Column (name="status")
	private String status;
	
	
	@Column (name="data_pedido")
	private LocalDate  data_pedido;
	
	@Column (name="data_prazo")
	private LocalDate  data_prazo;
	
	@Column(name = "fk_pessoa_id")
    private Long fk_pessoa_id;
	
	
	public Pedido() {
		super();
	}
	// List<ItemPedido> produtos,
	public Pedido(Long id, double valorTotal,String status , LocalDate data_pedido,LocalDate data_prazo, Long fk_pessoa_id ) {
		super();
		this.id = id;
		//this.produtos = produtos;
		this.valorTotal = valorTotal;
		this.status = status;
		this.data_pedido = data_pedido;
		this.data_prazo = data_prazo;
		this.fk_pessoa_id = fk_pessoa_id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/*
	public List<ItemPedido> getProdutos() {
		return this.produtos;
	}
	public void setProdutos(List<ItemPedido> produtos) {
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
