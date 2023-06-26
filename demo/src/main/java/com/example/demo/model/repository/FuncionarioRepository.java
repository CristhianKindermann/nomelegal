package com.example.demo.model.repository;
import com.example.demo.model.Funcionario;
import org.springframework.data.jpa.repository.*;



public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	//public Produto findById(int id);
}

