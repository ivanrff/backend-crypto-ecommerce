package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Moeda;
import com.example.demo.repository.MoedaRepository;

@Service
public class MoedaService {
	
	@Autowired
	private MoedaRepository moedaRepository;
	
	//create
	public Moeda create(Moeda moeda) {
		Moeda novaMoeda = new Moeda();
		
		novaMoeda.setAcronimo(moeda.getAcronimo());
		novaMoeda.setClose(moeda.getClose());
		novaMoeda.setMaxDiario(moeda.getMaxDiario());
		novaMoeda.setMinDiario(moeda.getMinDiario());
		novaMoeda.setNome(moeda.getNome());
		novaMoeda.setOpen(moeda.getOpen());
		novaMoeda.setPrecoInst(moeda.getPrecoInst());
		novaMoeda.setIconUrl(moeda.getIconUrl());
		
		moedaRepository.save(novaMoeda);
		
		return novaMoeda;
		
	}
	
	//readall
	public List<Moeda> listAll() {
		return moedaRepository.findAll();
	}
	//readbyid
	public Optional<Moeda> listById(Integer id) {
		return moedaRepository.findById(id);
	}
	
	//update
	public Moeda updateMoeda(Moeda moeda, Integer id) throws IOException, NotFoundException {
		
		if (moedaRepository.existsById(id)) {
			Moeda moedaAtt = moeda;
			moedaAtt.setId(id);
			moedaRepository.save(moedaAtt);
			
			return moedaAtt;
		}
		throw new NotFoundException();
	}
	
	//delete
	public void deleteMoeda(Integer id) throws NotFoundException {
		if (moedaRepository.existsById(id)) {
			moedaRepository.deleteById(id);
		} else {
			throw new NotFoundException();
		}
	}
}
