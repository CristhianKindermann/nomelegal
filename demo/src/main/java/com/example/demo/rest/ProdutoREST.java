package com.example.demo.rest;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.*;

@CrossOrigin
@RestController
public class ProdutoREST {
	public static List<Produto> produtos = new ArrayList<>();
	
	//Adicionar um produto
	
	@PostMapping("/produtos")
	Produto produto(@RequestBody Produto produto) {
		Produto prod = produtos.stream().max(Comparator.comparing(Produto::getId)).orElse(null);
		if (prod == null) 
			produto.setId(1);
		else
			produto.setId(prod.getId() + 1);
		produtos.add(produto);
		return produto;
		
	}

	//busca todos os produtos
	@GetMapping("/produtos")
	List<Produto> listarProdutos(){
		return produtos;
	}

	@PutMapping("/produtos/{id}")
	public Produto alterarProduto(@PathVariable("id") int id, @RequestBody Produto produto) {
		Produto p = produtos.stream().filter(prod -> prod.getId() == id).findAny().orElse(null);
		if(p != null) {
			p.setNome(produto.getNome());
			p.setValor(produto.getValor());
			p.setPrazo(produto.getPrazo());
		}
		return p;
	}
	
	@DeleteMapping("/produtos/{id}")
	public Produto removerPorduto(@PathVariable("id") int id) {
		Produto produto = produtos.stream().filter(prod -> prod.getId() == id).findAny().orElse(null);
		if(produto != null) {
			produtos.removeIf(p-> p.getId() == id);
		}
		
		return produto;
	}
	
	
	
	
	static {
		produtos.add(new Produto(1,"camiseta", 10.50, 1));
		produtos.add(new Produto(2,"camisa", 20.00, 3));
		produtos.add(new Produto(3,"calcas", 12.00, 2));
		produtos.add(new Produto(4,"cueca", 15.00, 1));
		produtos.add(new Produto(5,"meia", 9.00, 1));
	
	}
}
