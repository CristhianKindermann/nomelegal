package com.example.demo.model.repository;
import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
public Usuario findByEmail(String email);

}
