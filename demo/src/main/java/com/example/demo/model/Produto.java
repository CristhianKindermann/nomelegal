package com.example.demo.model;


import java.io.Serializable;

public class Produto implements Serializable {
	
	private int id;
	private String nome;
	private int prazo;
	private double valor;
	
	public Produto() {
		super();
	}
	
	public Produto(int id, String nome,double valor, int prazo ) {
		super();
		this.id = id;
		this.nome = nome;
		this.prazo = prazo;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPrazo() {
		return prazo;
	}
	
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}
