package com.example.demo.rest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.*;


@CrossOrigin
@RestController
public class UsuarioREST {
	public static List<Usuario> lista = new ArrayList<>();

	@PostMapping("/login")
	Usuario login(@RequestBody Login login) {
		//System.out.print(login.getEmail());
		Usuario usuario = lista.stream().
				filter(usu -> usu.getEmail().equals(login.getEmail()) && 
						usu.getSenha().equals(login.getSenha())).
				findAny().orElse(null);
		return usuario;
	}
	
	@PostMapping("/usuarios")
	Usuario inserirUsuario(@RequestBody Usuario usuario) {
		Usuario u  = lista.stream().max(Comparator.comparing(Usuario::getId)).orElse(null);
		if(u == null) {
			usuario.setId(1);
		}else {
			usuario.setId(u.getId() + 1);
		}
		
		lista.add(usuario);
		return usuario;
	}
	
	
	@PutMapping("/usuarios/{id}")
	Usuario atualizarUsuario(@PathVariable("id") int id, @RequestBody Usuario usuario) {
		Usuario u  = lista.stream().max(Comparator.comparing(Usuario::getId)).orElse(null);
		if(u != null) {
			u.setNome(usuario.getNome());
			u.setEmail(usuario.getEmail());
			u.setSenha(usuario.getSenha());
			u.setPerfil(usuario.getPerfil());
		}
		return u;
	}
	
	@GetMapping("/usuarios")
	List<Usuario> obterTodosUsuarios() {
		return lista;
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario obterUsuario(@PathVariable("id") int id) {
		Usuario u = lista.stream().filter(usu -> usu.getId() == id).findAny().orElse(null);
		return u;
	}
	
	static {
		lista.add(new Usuario(1, "administr", "admin@admin.com", "1234", "Funcionario"));
		lista.add(new Usuario(2, "cliente", "cliente@cliente.com", "1234", "Cliente"));
	}
}
