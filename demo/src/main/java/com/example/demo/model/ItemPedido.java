package com.example.demo.model;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tem")
public class ItemPedido implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Float valor;
	
	//private int prazo;
	
	@Column (name="nome")
	private String nome;
	
	@ManyToOne
    @JoinColumn(name = "fk_pedido_id")
    private Pedido pedido;
	
	@ManyToOne
    @JoinColumn(name = "fk_produto_id")
    private Produto produto;
	
	@Column(name="quantidade")
	private int quantidade;
	
	public ItemPedido() {
		super();
	} 

	public ItemPedido(Long id, String nome, Float valor, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	} 
	
	
	
}
