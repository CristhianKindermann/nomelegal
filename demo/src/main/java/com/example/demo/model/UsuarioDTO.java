package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
public class UsuarioDTO implements Serializable {
	
private Long id;
private String nome;
private String cpf;
private String email;
private String senha;
private String telefone;
private String cep;
private String rua;
private String numero;
private String cidade;
private String uf;
private String bairro;
private String complemento;
private String perfil;
private LocalDate data_nascimento;


public UsuarioDTO() {
	super();
} 

public UsuarioDTO(Long id, String nome,String cpf, String email, String senha,String telefone,String cep,String rua, String numero, String cidade, String uf, String bairro, String complemento, String perfil, LocalDate data_nascimento) {
	super();
	this.id = id;
	this.nome = nome;
	this.cpf = cpf;
	this.email = email;
	this.senha = senha;
	this.telefone = telefone;
	this.cep = cep;
	this.rua = rua;
	this.numero = numero;
	this.cidade = cidade;
	this.uf = uf;
	this.bairro = bairro;
	this.complemento = complemento;
	this.perfil = perfil;
	this.data_nascimento = data_nascimento;
	
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

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public String getTelefone() {
	return telefone;
}

public void setTelefone(String telefone) {
	this.telefone = telefone;
}

public String getCep() {
	return cep;
}

public void setCep(String cep) {
	this.cep = cep;
}

public String getRua() {
	return rua;
}

public void setRua(String rua) {
	this.rua = rua;
}

public String getNumero() {
	return numero;
}

public void setNumero(String numero) {
	this.numero = numero;
}

public String getCidade() {
	return cidade;
}

public void setCidade(String cidade) {
	this.cidade = cidade;
}

public String getUf() {
	return uf;
}

public void setUf(String uf) {
	this.uf = uf;
}

public String getBairro() {
	return bairro;
}

public void setBairro(String bairro) {
	this.bairro = bairro;
}

public String getComplemento() {
	return complemento;
}

public void setComplemento(String complemento) {
	this.complemento = complemento;
}

public String getPerfil() {
	return perfil;
}

public void setPerfil(String perfil) {
	this.perfil = perfil;
}

public LocalDate getData_nascimento() {
	return data_nascimento;
}

public void setData_nascimento(LocalDate data_nascimento) {
	this.data_nascimento = data_nascimento;
}}

