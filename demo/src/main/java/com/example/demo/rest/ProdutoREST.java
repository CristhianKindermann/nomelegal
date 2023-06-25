package com.example.demo.rest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

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
		//repo.save(mapper.map(produto, Produto.class));
		Produto prod = mapper.map(produto, Produto.class);
		repu.save(prod);
		Produto p = repu.findById(prod.getId()).get();
		return mapper.map(p, ProdutoDTO.class);
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
	public ProdutoDTO alterarProduto(@PathVariable("id") Long id, @RequestBody ProdutoDTO produtoDTO) {
		Optional<Produto> optionalProduto = repu.findById(id);

        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();

            // Atualize os campos relevantes com base nos valores do ProdutoDTO
            produto.setNome(produtoDTO.getNome());
            produto.setValor_unitario(produtoDTO.getValor_unitario());
            
            repu.save(produto);
            return mapper.map(produto, ProdutoDTO.class);
        }else{
        	return null;

        }
        
	}
	
	@DeleteMapping("/produtos/{id}")
	@ResponseBody
	public ProdutoDTO removerPorduto(@PathVariable("id") Long id) {
		Optional<Produto> optionalProduto = repu.findById(id);
		if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            
            repu.delete(produto);
            return mapper.map(produto, ProdutoDTO.class);
            
        } else {
        	return null;

        }

	}
	

} 