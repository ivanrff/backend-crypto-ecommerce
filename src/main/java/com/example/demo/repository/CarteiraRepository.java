package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Carteira;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Integer> {
	
	public Optional<Carteira> findByUsuarioId(Integer id);
	
}
