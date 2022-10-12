package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//create
	public Usuario createUsuario(Usuario usuario) {
		Usuario novoUsuario = new Usuario();
		
		novoUsuario.setNome(usuario.getNome());
		novoUsuario.setCpf(usuario.getCartaoCredito());
		novoUsuario.setEmail(usuario.getEmail());
		novoUsuario.setCartaoCredito(usuario.getCartaoCredito());
		novoUsuario.setCidade(usuario.getCidade());
		novoUsuario.setRua(usuario.getRua());
		novoUsuario.setUf(usuario.getUf());
		novoUsuario.setBairro(usuario.getBairro());
		novoUsuario.setPerfil(usuario.getPerfil());
		
		usuarioRepository.save(novoUsuario);
		
		return novoUsuario;
	}
	
	//read
	public List<Usuario> listAll() {
		
		List<Usuario> list = usuarioRepository.findAll();
		
		return list;
	}
	
	//find by id
	public Optional<Usuario> listById(Integer id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return usuario;
	}
	
	
	//update
	public Usuario updateUsuario(Usuario usuario, Integer id) throws IOException, NotFoundException {
		
		if (usuarioRepository.existsById(id)) {
			Usuario usuarioAtualizado = usuario;
			usuarioAtualizado.setId(id);
			usuarioRepository.save(usuarioAtualizado);
			
			return usuarioAtualizado;
		}
		throw new NotFoundException();
	}
	
	//delete
	public void	delete(Integer id) throws NotFoundException {
		if(usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
		} else {
			throw new NotFoundException();
		}
	}
}
