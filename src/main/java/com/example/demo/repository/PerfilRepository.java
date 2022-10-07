package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
	
	public Optional<Perfil> findByNome(String nome);
	//findById eh padrao
}
