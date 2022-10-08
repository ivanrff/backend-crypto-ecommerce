package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Perfil;
import com.example.demo.service.PerfilService;

@CrossOrigin(origins = "", allowedHeaders = "")
@RestController
@RequestMapping("/perfis") //padrao plural
public class PerfilController {
	
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping
	public List<Perfil> listAll() {
		List<Perfil> lista = perfilService.listAll();
		
		return lista;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Perfil>> listById(@PathVariable Integer id) throws NotFoundException {
		if (perfilService.listById(id) != null) {
			return ResponseEntity.ok(perfilService.listById(id));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/create")
	public Perfil createPerfil(@Valid @RequestBody Perfil perfil) {
		
		return perfilService.create(perfil);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePerfil(@Valid @RequestBody Perfil perfilRequest, @PathVariable Integer id) throws NotFoundException {

		try {
            Perfil perfil  = perfilService.update(perfilRequest, id);
            if ((perfil != null) && (perfil.getId() != null)) {

                return ResponseEntity.ok(perfil);
            }
        } catch (IOException e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePerfil(@PathVariable Integer id) throws NotFoundException {
		if (perfilService.listById(id) != null) {
			perfilService.delete(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
