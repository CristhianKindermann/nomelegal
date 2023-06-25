package com.example.demo.model.repository;
import com.example.demo.model.Produto;
import org.springframework.data.jpa.repository.*;



public interface ProdutoRepository  extends JpaRepository<Produto, Long>{
	public Produto findByid(Integer id);

}
