package com.example.demo.model;
import java.io.Serializable;

public class ProdutoDTO implements Serializable {
	
	private Long id;
	private String nome;
	private int prazo;
	private Float valor_unitario;
	
	public ProdutoDTO() {
		super();
	}
	
	public ProdutoDTO(Long id, String nome,Float valor_unitario, int prazo ) {
		super();
		this.id = id;
		this.nome = nome;
		this.prazo = prazo;
		this.valor_unitario = valor_unitario;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
	
	public Float getValor_unitario() {
		return valor_unitario;
	}
	
	public void setValor_unitario(Float valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	
	

}
