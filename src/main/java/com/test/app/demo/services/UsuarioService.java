package com.test.app.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.demo.entities.Usuario;
import com.test.app.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> procuraTodos() {
		return repository.findAll();
	}

	public Usuario procuraPorId(Integer id) {
		return repository.findById(id).get();
	}

	public String adicionarUsuario(Usuario usuario) {
		repository.save(usuario);
		return "usuario adicionado com sucesso!";
	}

	public String editarUsuario(Integer id, Usuario usuario) {
		Usuario response = repository.findById(id).get();

		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setSenha(usuario.getSenha());

		repository.save(response);
		return "Usuario editado com sucesso!";
	}

	public void excluirUsuario(Integer id) {
		Usuario response = repository.findById(id).get();
		repository.delete(response);
	}
}
