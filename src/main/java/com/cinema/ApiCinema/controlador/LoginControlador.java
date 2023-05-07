package com.cinema.ApiCinema.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.ApiCinema.model.Usuario;
import com.cinema.ApiCinema.repository.UsuarioRepositorio;

@RestController
public class LoginControlador {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@GetMapping(value = "/login")
	public @ResponseBody Iterable<Usuario> getUsuario() { 
		return usuarioRepositorio.findAll();
	}

}
			