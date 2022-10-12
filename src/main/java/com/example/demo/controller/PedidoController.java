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

import com.example.demo.model.Pedido;
import com.example.demo.service.PedidoService;

@CrossOrigin(origins = "", allowedHeaders = "")
@RestController
@RequestMapping("/pedidos") //padrao plural
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	//get
	@GetMapping
	public List<Pedido> getAll() {
		return pedidoService.listAll();
	}
	//getbyid
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pedido>> getById(@PathVariable Integer id) throws NotFoundException {
		if (pedidoService.listById(id)!=null) {
			return ResponseEntity.ok(pedidoService.listById(id));
		}
		else return ResponseEntity.notFound().build();
		
	}
	//post
	@PostMapping("/create")
	public Pedido createPedido(@Valid @RequestBody Pedido pedido) {
		return pedidoService.createPedido(pedido);
	}
	
	//put
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePedido(@PathVariable Integer id, @Valid @RequestBody Pedido pedido) throws NotFoundException {
		try {
			Pedido pedidoAtt = pedidoService.updatePedido(pedido, id);
			if ((pedidoAtt!=null)&&(pedidoAtt.getId()!=null)) {
				return ResponseEntity.ok(pedidoAtt);
			}
		} catch(IOException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		return ResponseEntity.notFound().build();
	}
		
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePedido(@PathVariable Integer id) throws NotFoundException {
		if (pedidoService.listById(id)!=null) {
			pedidoService.deletePedido(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
