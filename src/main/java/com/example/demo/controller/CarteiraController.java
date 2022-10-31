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

import com.example.demo.model.Carteira;
import com.example.demo.service.CarteiraService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/carteiras") //padrao plural
public class CarteiraController {
	
	@Autowired
	private CarteiraService carteiraService;
	
	//get
	@GetMapping
	public List<Carteira> listAll() {
		List<Carteira> lista = carteiraService.listAll();
		
		return lista;
	}
	
	//getbyid
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Carteira>> listById(@PathVariable Integer id) throws NotFoundException {
		if (carteiraService.listById(id) != null) {
			return ResponseEntity.ok(carteiraService.listById(id));
		}
		return ResponseEntity.notFound().build();
	}
	
	//post
	@PostMapping("/create")
	public Carteira createCarteira(@Valid @RequestBody Carteira carteira) {
		return carteiraService.createCarteira(carteira);
	}
	
	//put
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCarteira(@Valid @RequestBody Carteira carteiraRequest, @PathVariable Integer id) throws NotFoundException {
		try {
			Carteira carteira = carteiraService.updateCarteira(carteiraRequest, id);
			if ((carteira != null) && (carteira.getId() != null)) {
				return ResponseEntity.ok(carteira);
			}
		} catch (IOException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		return ResponseEntity.notFound().build();
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCarteira(@PathVariable Integer id) throws NotFoundException {
		if (carteiraService.listById(id) != null) {
			carteiraService.deleteCarteira(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
