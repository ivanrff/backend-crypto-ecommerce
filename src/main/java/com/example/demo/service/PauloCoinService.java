package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.PauloCoin;
import com.example.demo.repository.PauloCoinRepository;

@Service
public class PauloCoinService {
	
	@Autowired
	private PauloCoinRepository pauloCoinRepository;
	
	//create
	public PauloCoin create(PauloCoin pauloCoin) {
		
		PauloCoin novaPauloCoin = new PauloCoin();
		
		novaPauloCoin.setPrecoReal(pauloCoin.getPrecoReal());
		novaPauloCoin.setDataAtt(pauloCoin.getDataAtt());
		
		pauloCoinRepository.save(novaPauloCoin);
		
		return novaPauloCoin;
	}
	
	//readall
	public List<PauloCoin> listAll() {
		return pauloCoinRepository.findAll();
	}
	
	//readbyid
	public Optional<PauloCoin> listById(Integer id) {
		return pauloCoinRepository.findById(id);
	}
	
	//update
	public PauloCoin updatePauloCoin(PauloCoin pauloCoin, Integer id) throws IOException, NotFoundException {
		if (pauloCoinRepository.existsById(id)) {
			PauloCoin pauloCoinAtt = pauloCoin;
			pauloCoinAtt.setId(id);
			pauloCoinRepository.save(pauloCoinAtt);
			
			return pauloCoinAtt;
		}
		throw new NotFoundException();
	}
	
	//delete
	public void deletePauloCoin(Integer id) throws NotFoundException {
		if (pauloCoinRepository.existsById(id)) {
			pauloCoinRepository.deleteById(id);
		} else {
			throw new NotFoundException();
		}
	}
}
