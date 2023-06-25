package com.example.demo.model;
import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="pessoa")

public class Usuario 
	implements Serializable{
		private static final Long
		serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column (name="id")
	private Long id;
		
	@Column (name="nome")
	private String nome;
	
	@Column (name="cpf")
	private String cpf;
	
	@Column (name="email")
	private String email;
	
	@Column (name="senha")
	private String senha;
	
	@Column (name="telefone")
	private String telefone;
	
	@Column (name="cep")
	private String cep;
	
	@Column (name="rua")
	private String rua;
	
	@Column (name="numero")
	private String numero;
	
	@Column (name="cidade")
	private String cidade;
	
	@Column (name="uf")
	private String uf;
	
	@Column (name="bairro")
	private String bairro;
	
	@Column (name="complemento")
	private String complemento;
	
	@Column (name="tipo")
	private String tipo;
	
	@Column (name="data_nascimento")
	private String data_nascimento;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	}

