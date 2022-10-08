package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Perfil;
import com.example.demo.repository.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	//read todos
	public List<Perfil> listAll() {
		List<Perfil> lista = perfilRepository.findAll();
		
		return lista;
	}
	
	//read carinha especifico
	public Optional<Perfil> listById(Integer id) {
		Optional<Perfil> perfil = perfilRepository.findById(id); //esse e padrao
		
		return perfil;
	}
	
	//create
	public Perfil create(Perfil perfil) {
		Perfil novoPerfil = new Perfil();
		novoPerfil.setNome(perfil.getNome());
		
		perfilRepository.save(novoPerfil);
		
		return novoPerfil;
	}
	
	//update
	public Perfil update(Perfil perfil, Integer id) throws IOException, NotFoundException {
		
		if (perfilRepository.existsById(id)) {
			Perfil perfilEditado = new Perfil();
			perfilEditado.setId(id);
			perfilEditado.setNome(perfil.getNome());
			perfilRepository.save(perfilEditado);
			return perfilEditado;
		}
		throw new NotFoundException();
	}
	
	//deletar;
	public void delete(Integer id) throws NotFoundException {
		if (perfilRepository.existsById(id)) {
			perfilRepository.deleteById(id);
		} else {
			throw new NotFoundException();
		}
	}
}
