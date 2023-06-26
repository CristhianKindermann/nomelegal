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
@Table(name="pessoa")
public class Funcionario implements Serializable{
	
	private static final Long
	serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	
	//@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<ItemPedido> produtos = new ArrayList<>();
	
	//private static List<ItemPedidoDTO> produtos = new ArrayList<>();
	
	@Column (name="nome")
	private String nome;
	
	@Column (name="data_nascimento")
	private LocalDate  data_nascimento;
	
	@Column (name="senha")
	private String  senha;
	
	@Column(name = "email")
    private String email;
	
	
	public Funcionario() {
		super();
	}
	// List<ItemPedido> produtos,
	public Funcionario(int id,  String email,String nome , LocalDate data_nascimento, String senha ) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate  getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
