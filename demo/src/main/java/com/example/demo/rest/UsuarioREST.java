package com.example.demo.rest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.*;
import com.example.demo.model.repository.*;
import org.springframework.stereotype.*;

@CrossOrigin
@RestController
public class UsuarioREST {
	@Autowired
	private UsuarioRepository repo;
	@Autowired
	private ModelMapper mapper;
	
	public static List<UsuarioDTO> lista = new ArrayList<>();

	@PostMapping("/login")
	UsuarioDTO login(@RequestBody Login login) {
		//System.out.print(login.getEmail());
		UsuarioDTO usuario = lista.stream().
				filter(usu -> usu.getEmail().equals(login.getEmail()) && 
						usu.getSenha().equals(login.getSenha())).
				findAny().orElse(null);
		return usuario;
	}
	
	@PostMapping("/usuarios")
	UsuarioDTO inserirUsuario(@RequestBody UsuarioDTO usuario) {
/*		UsuarioDTO u  = lista.stream().max(Comparator.comparing(UsuarioDTO::getId)).orElse(null);
		if(u == null) {
			usuario.setId(1);
		}else {
			usuario.setId(u.getId() + 1);
		}
		
		lista.add(usuario);
		return usuario;
	} */
		repo.save(mapper.map(usuario, Usuario.class));
		Usuario usu = repo.findByEmail(
				usuario.getEmail());
		return mapper.map(usu,  UsuarioDTO.class);
	}
	
	@PutMapping("/usuarios/{id}")
	UsuarioDTO atualizarUsuario(@PathVariable("id") int id, @RequestBody UsuarioDTO usuario) {
		UsuarioDTO u  = lista.stream().max(Comparator.comparing(UsuarioDTO::getId)).orElse(null);
		if(u != null) {
			u.setNome(usuario.getNome());
			u.setEmail(usuario.getEmail());
			u.setSenha(usuario.getSenha());
			u.setPerfil(usuario.getPerfil());
		}
		return u;
	}
	
	@GetMapping("/usuarios")
	List<UsuarioDTO> obterTodosUsuarios() {
		return lista;
	}
	
	@GetMapping("/usuarios/{id}")
	public UsuarioDTO obterUsuario(@PathVariable("id") int id) {
		UsuarioDTO u = lista.stream().filter(usu -> usu.getId() == id).findAny().orElse(null);
		return u;
	}
	
	static {
		lista.add(new UsuarioDTO(1, "administr", "admin@admin.com", "1234", "Funcionario"));
		lista.add(new UsuarioDTO(2, "cliente", "cliente@cliente.com", "1234", "Cliente"));
	}
} 
