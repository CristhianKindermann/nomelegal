package com.example.demo.model;
import java.io.Serializable;


public class ItemPedido extends ProdutoDTO implements Serializable{
	private int id;
	private double valor;
	private int prazo;
	private String nome;
	private int quantidade;
	
	public ItemPedido() {
		super();
	} 

	public ItemPedido(int id, String nome, double valor, int prazo, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.prazo = prazo;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
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
