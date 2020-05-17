package com.example.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.banco.domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
 
	@Query(value = "SELECT p.id, p.nome FROM Pais p WHERE p.nome = :nome ", nativeQuery = true)
	public Pais buscarPaisPorNome(@Param("nome")  String nome);
	
}
