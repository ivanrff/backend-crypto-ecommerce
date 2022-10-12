package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	//create
	public Pedido createPedido(Pedido pedido) {
		
		Pedido novoPedido = new Pedido();
		pedido.setId(novoPedido.getId());
		
		return pedido;
	}
	
	//readall
	public List<Pedido> listAll() {
		return pedidoRepository.findAll();
	
	}
	
	//readbyid
	public Optional<Pedido> listById(Integer id) {
		return pedidoRepository.findById(id);
	}
	//update
	public Pedido updatePedido(Pedido pedido, Integer id) throws IOException, NotFoundException {
		if (pedidoRepository.existsById(id)) {
			Pedido pedidoAtt = pedido;
			pedidoAtt.setId(id);
			pedidoRepository.save(pedidoAtt);
			
			return pedidoAtt;
		}
		throw new NotFoundException();
		
	}
	//delete
	public void deletePedido(Integer id) throws NotFoundException {
		if (pedidoRepository.existsById(id)) {
			pedidoRepository.deleteById(id);
		}
		throw new NotFoundException();
	}
}
