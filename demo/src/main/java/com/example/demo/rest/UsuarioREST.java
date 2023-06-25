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
import java.time.LocalDate;

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
	UsuarioDTO Usuario(@RequestBody UsuarioDTO usuario) {
		Usuario usu = mapper.map(usuario, Usuario.class);
		repo.save(usu);
		Usuario u = repo.findById(usu.getId()).get();
		return mapper.map(u, UsuarioDTO.class);
	}
	
/*		UsuarioDTO u  = lista.stream().max(Comparator.comparing(UsuarioDTO::getId)).orElse(null);
		if(u == null) {
			usuario.setId(1);
		}else {
			usuario.setId(u.getId() + 1);
		}
		
		lista.add(usuario);
		return usuario;
	} */

	
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
		lista.add(new UsuarioDTO(1L, "administrador", "109.555.231-00", "admin@admin.com", "1234", "999999999", "01234-567", "Rua Exemplo", "123", "Cidade Exemplo", "UF", "Bairro Exemplo", "Complemento Exemplo", "Funcionario", LocalDate.of(1990, 1, 1)));
		lista.add(new UsuarioDTO(2L, "cliente","109.233.232-55", "cliente@cliente.com", "1234","41999335588", "1349260", "ruaze", "12", "colombo", "pr", "zumbi", "fundos", "Cliente",LocalDate.of(1990, 1, 1)));
	}
} 
