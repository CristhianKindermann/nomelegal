package com.example.demo.rest;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.repository.*;
import org.springframework.stereotype.*;

@CrossOrigin
@RestController
public class ProdutoREST {
	
	@Autowired
	private ProdutoRepository repu;
	@Autowired
	private ModelMapper mapper;
	public static List<ProdutoDTO> produtos = new ArrayList<>();
	
	//Adicionar um produto
	
	@PostMapping("/produtos")
	ProdutoDTO produto(@RequestBody ProdutoDTO produto) {
//		ProdutoDTO prod = produtos.stream().max(Comparator.comparing(ProdutoDTO::getId)).orElse(null);
//		if (prod == null) 
//			produto.setId(1);
//		else
//			produto.setId(prod.getId() + 1);
//		produtos.add(produto);
//		return produto;

		repu.save(mapper.map(produto, Produto.class));
		
		Produto prod = repu.findByid(
				produto.getId());
		return mapper.map(prod, ProdutoDTO.class);
	}

	//busca todos os produtos
	@GetMapping("/produtos")
	List<ProdutoDTO> listarTodos(){
		List<Produto> lista = repu.findAll();
	//	return produtos;
		return lista.stream()
				.map(e -> mapper.map(e,
						ProdutoDTO.class))
				.collect(Collectors.toList());
	}

	@PutMapping("/produtos/{id}")
	public ProdutoDTO alterarProduto(@PathVariable("id") int id, @RequestBody ProdutoDTO produto) {
		ProdutoDTO p = produtos.stream().filter(prod -> prod.getId() == id).findAny().orElse(null);
		if(p != null) {
			p.setNome(produto.getNome());
			p.setValor(produto.getValor());
			p.setPrazo(produto.getPrazo());
		}
		return p;
	}
	
	@DeleteMapping("/produtos/{id}")
	public ProdutoDTO removerPorduto(@PathVariable("id") int id) {
		ProdutoDTO produto = produtos.stream().filter(prod -> prod.getId() == id).findAny().orElse(null);
		if(produto != null) {
			produtos.removeIf(p-> p.getId() == id);
		}
		
		return produto;
	}
	
	
	
	
	static {
		produtos.add(new ProdutoDTO(1,"camiseta", 10.50, 1));
		produtos.add(new ProdutoDTO(2,"camisa", 20.00, 3));
		produtos.add(new ProdutoDTO(3,"calcas", 12.00, 2));
		produtos.add(new ProdutoDTO(4,"cueca", 15.00, 1));
		produtos.add(new ProdutoDTO(5,"meia", 9.00, 1));
	
	}
} 