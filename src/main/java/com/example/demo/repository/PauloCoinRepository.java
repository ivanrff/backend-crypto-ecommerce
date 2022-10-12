package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PauloCoin;

@Repository
public interface PauloCoinRepository extends JpaRepository<PauloCoin, Integer> {

}
