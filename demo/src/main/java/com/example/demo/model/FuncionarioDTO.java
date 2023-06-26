package com.example.demo.model;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import  org.springframework.format.annotation.DateTimeFormat;


public class FuncionarioDTO implements Serializable{
	
	private int id;
	private String email;
	private String nome;
	private LocalDate data_nascimento;
	private String senha;
	
	
	public FuncionarioDTO() {
		super();
	}
	
	public FuncionarioDTO(int id,  String email,String nome , LocalDate data_nascimento, String senha ) {
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
