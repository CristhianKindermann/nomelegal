package com.example.demo.model;
import java.io.Serializable;


public class ItemPedidoDTO extends ProdutoDTO implements Serializable{
	private Long id;
	private Float valor;
	private String nome;
	private int quantidade;
	
	public ItemPedidoDTO() {
		super();
	} 

	public ItemPedidoDTO(Long id, String nome, Float valor,  int quantidade) {
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
