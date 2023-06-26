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
public class FuncionarioREST {
	
	@Autowired
	private FuncionarioRepository repu;
	@Autowired
	private ModelMapper mapper;
	public static List<FuncionarioDTO> funcionarios = new ArrayList<>();
	
	//Adicionar um produto
	
	@PostMapping("/funcionarios")
	FuncionarioDTO funcionario(@RequestBody FuncionarioDTO funcionario) {
		//repo.save(mapper.map(produto, Produto.class));
		Funcionario func = mapper.map(funcionario, Funcionario.class);
		repu.save(func);
		Funcionario p = repu.findById(func.getId()).get();
		return mapper.map(p, FuncionarioDTO.class);
	}

	//busca todos os produtos
	@GetMapping("/funcionarios")
	List<FuncionarioDTO> listarTodos(){
		List<Funcionario> lista = repu.findAll();
	//	return produtos;
		return lista.stream()
				.map(e -> mapper.map(e,
						FuncionarioDTO.class))
				.collect(Collectors.toList());
	}
//
	@PutMapping("/funcionarios/{id}")
	public FuncionarioDTO alterarProduto(@PathVariable("id") int id, @RequestBody FuncionarioDTO funcionarioDTO) {
		Optional<Funcionario> optionalFuncionario = repu.findById(id);

        if (optionalFuncionario.isPresent()) {
        	Funcionario funcionario = optionalFuncionario.get();

            // Atualize os campos relevantes com base nos valores do ProdutoDTO
        	funcionario.setNome(funcionarioDTO.getNome());
			funcionario.setData_nascimento(funcionarioDTO.getData_nascimento());
			funcionario.setEmail(funcionarioDTO.getEmail());
			funcionario.setSenha(funcionarioDTO.getSenha());
            
            repu.save(funcionario);
            return mapper.map(funcionario, FuncionarioDTO.class);
        }else{
        	return null;

        }
        
	}
	
	@DeleteMapping("/funcionarios/{id}")
	@ResponseBody
	public FuncionarioDTO removerPorduto(@PathVariable("id") int id) {
		Optional<Funcionario> optionalFuncionario = repu.findById(id);
		if (optionalFuncionario.isPresent()) {
			Funcionario funcionario = optionalFuncionario.get();
            
            repu.delete(funcionario);
            return mapper.map(funcionario, FuncionarioDTO.class);
            
        } else {
        	return null;

        }

	}
	

} 