package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Moeda;

@Repository
public interface MoedaRepository extends JpaRepository<Moeda, Integer> {

}
