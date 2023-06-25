package com.example.demo.model.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	 @Query("SELECT p FROM Pedido p WHERE p.data_pedido BETWEEN :inicio AND :fim")
	    List<Pedido> findByDataPedidoBetween(
	            @Param("inicio") LocalDate inicio,
	            @Param("fim") LocalDate fim
	    );
	 
	 @Query("SELECT p FROM Pedido p WHERE p.data_pedido = :hoje")
	    List<Pedido> findByDataPedido(@Param("hoje") LocalDate hoje);
	 
	 
	 @Query("SELECT p FROM Pedido p WHERE p.status = :status AND p.fk_pessoa_id = :id_cliente")
	    List<Pedido> findByStatusAndPessoaId(
	            @Param("status") String status,
	            @Param("id_cliente") Long id_cliente
	    );
	 
	 @Query("SELECT p FROM Pedido p WHERE p.status = :status")
	    List<Pedido> findByStatus(@Param("status") String status);

}
