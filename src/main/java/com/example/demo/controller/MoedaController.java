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

import com.example.demo.model.Moeda;
import com.example.demo.service.MoedaService;

@CrossOrigin(origins = "", allowedHeaders = "")
@RestController
@RequestMapping("/moedas") //padrao plural
public class MoedaController {
	
	@Autowired
	private MoedaService moedaService;
	
	//post
	@PostMapping("/create")
	public Moeda createMoeda(@Valid @RequestBody Moeda moeda) {
		return moedaService.create(moeda);
	}
	
	//get
	@GetMapping
	public List<Moeda> listAll() {
		return moedaService.listAll();
	}
	
	//getbyid
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Moeda>> listById(@PathVariable Integer id) throws NotFoundException {
		if (moedaService.listById(id)!=null) {
			return ResponseEntity.ok(moedaService.listById(id));
		}
		return ResponseEntity.notFound().build();
	}
	//put
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateMoeda(@Valid @RequestBody Moeda moeda, @PathVariable Integer id) throws NotFoundException {
		try {
			Moeda moedaAtt = moedaService.updateMoeda(moeda, id);
			if ((moedaAtt!=null) && (moedaAtt.getId()!=null)){
				return ResponseEntity.ok(moedaAtt);
			}
		} catch (IOException e){
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		return ResponseEntity.notFound().build();
	}
	
	//delete
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteMoeda(@PathVariable Integer id) throws NotFoundException {
		if (moedaService.listById(id)!=null) {
			moedaService.deleteMoeda(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
