package com.cinema.ApiCinema.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.ApiCinema.model.Usuario;
import com.cinema.ApiCinema.repository.UsuarioRepositorio;

@RestController
public class LoginControlador {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
    @CrossOrigin
    @PostMapping("/login")
    public Map<String, String> login(@RequestParam Map<String, String> usuario ){
    	Usuario _usuario = new Usuario();
   
    	_usuario.setSenha(usuario.get("senha"));
      	 usuarioRepositorio.findByEmail(usuario.get("email"));
    	return usuario;
    }
	
    @CrossOrigin
    @PostMapping("/cadastro")
    public Map<String, String> cadastro(@RequestParam Map<String, String> usuario ){
    	Usuario _usuario = new Usuario();
    	_usuario.setEmail(usuario.get("email"));
    	_usuario.setSenha(usuario.get("senha"));
      	 usuarioRepositorio.save(_usuario);
    	return usuario;
    }
	
}
			