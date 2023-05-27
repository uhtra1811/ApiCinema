package com.cinema.ApiCinema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cinema.ApiCinema.model.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
		List<Usuario> findByEmail(String email);
	

}
