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

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@CrossOrigin(origins = "", allowedHeaders = "")
@RestController
@RequestMapping("/usuarios") //padrao plural
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//get
	@GetMapping
	public List<Usuario> listAll() {
		List<Usuario> lista = usuarioService.listAll();
		
		return lista;
	}
	
	//getbyid
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> listById(@PathVariable Integer id) throws NotFoundException {
		if (usuarioService.listById(id) != null) {
			return ResponseEntity.ok(usuarioService.listById(id));
		}
		return ResponseEntity.notFound().build();
	}
	
	//post
	@PostMapping("/create")
	public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.createUsuario(usuario);
	}
	
	//put
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUsuario(@Valid @RequestBody Usuario usuarioRequest, @PathVariable Integer id) throws NotFoundException {
		try {
			Usuario usuario = usuarioService.updateUsuario(usuarioRequest, id);
			if ((usuario != null) && (usuario.getId() != null)) {
				return ResponseEntity.ok(usuario);
			}
		} catch (IOException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		return ResponseEntity.notFound().build();
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) throws NotFoundException {
		if (usuarioService.listById(id) != null) {
			usuarioService.delete(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
