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

import com.example.demo.model.PauloCoin;
import com.example.demo.service.PauloCoinService;

@CrossOrigin(origins="", allowedHeaders = "")
@RestController
@RequestMapping("/paulocoins")
public class PauloCoinController {
	
	@Autowired
	private PauloCoinService pauloCoinService;
	
	//getall
	@GetMapping
	public List<PauloCoin> getAll() {
		return pauloCoinService.listAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<PauloCoin>> getById(@PathVariable Integer id) throws NotFoundException {
		
		if (pauloCoinService.listById(id)!=null) {
			return ResponseEntity.ok(pauloCoinService.listById(id));
		}
		return ResponseEntity.notFound().build();
	}
	//post
	@PostMapping("/create")
	public PauloCoin createPauloCoin(@Valid @RequestBody PauloCoin pauloCoin) {
		return pauloCoinService.create(pauloCoin);
	}
	//put
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateById(@PathVariable Integer id, @Valid @RequestBody PauloCoin pauloCoin) throws NotFoundException {
		try {
			PauloCoin pauloCoinAtt = pauloCoinService.updatePauloCoin(pauloCoin, id);
			if ((pauloCoinAtt!=null)&&(pauloCoinAtt.getId()!=null)) {
				return ResponseEntity.ok(pauloCoinAtt);
			}
		} catch (IOException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		return ResponseEntity.notFound().build();
	}
	
	//delete
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) throws NotFoundException {
		if (pauloCoinService.listById(id)!=null) {
			pauloCoinService.deletePauloCoin(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
