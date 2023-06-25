package com.example.demo.model;
import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="produto")
public class Produto 	
implements Serializable{
	private static final Long
	serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column (name="nome")
	private String nome;
	
	@Column (name="valor_unitario")
	private Float valor_unitario;
	
	@Column (name="prazo")
	private String prazo;

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

	public Float getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(Float valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

}
