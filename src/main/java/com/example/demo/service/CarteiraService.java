package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Carteira;
import com.example.demo.repository.CarteiraRepository;

@Service
public class CarteiraService {
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	//crud
	
	public Carteira createCarteira(Carteira carteira) {
		Carteira novaCarteira = new Carteira();
		carteira.setId(novaCarteira.getId());
		return carteira;
	}
	
	public List<Carteira> listAll() {
		return carteiraRepository.findAll();
	}
	
	public Optional<Carteira> listById(Integer id) {
		return carteiraRepository.findById(id);
	}
	
	public Carteira updateCarteira(Carteira carteira, Integer id) throws IOException, NotFoundException {
		if (carteiraRepository.existsById(id)) {
			Carteira carteiraAtt = carteira;
			carteiraAtt.setId(id);
			carteiraRepository.save(carteiraAtt);
			
			return carteiraAtt;
		}
		throw new NotFoundException();
	}
	
	public void deleteCarteira(Integer id) throws NotFoundException {
		if (carteiraRepository.existsById(id)) {
			carteiraRepository.deleteById(id);
		}
		throw new NotFoundException();
	}
}
