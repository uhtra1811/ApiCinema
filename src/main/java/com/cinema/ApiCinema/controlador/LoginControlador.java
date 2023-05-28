package com.cinema.ApiCinema.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.ApiCinema.model.Usuario;
import com.cinema.ApiCinema.repository.UsuarioRepositorio;

@RestController
public class LoginControlador {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
    
    @CrossOrigin
    @PostMapping("/login")
    public Usuario login(@RequestParam Map<String, String> usuario ){
    	System.out.println(usuario);
    	Usuario _usuario = new Usuario();
      	_usuario = usuarioRepositorio.findByEmailAndSenha(usuario.get("email"), usuario.get("senha")).stream().findFirst().orElse(null);
    	return _usuario;
    }
    
	@CrossOrigin
    @PostMapping("/cadastro")
    public Usuario cadastro(@RequestParam Map<String, String> usuario ){
    	Usuario _usuario = new Usuario();
    	_usuario = usuarioRepositorio.findByEmail(usuario.get("email")).stream().findFirst().orElse(null);
    	if(_usuario == null) {
    		_usuario = new Usuario();
        	_usuario.setEmail(usuario.get("email"));
        	_usuario.setSenha(usuario.get("senha"));
        	_usuario.setPergunta(usuario.get("pergunta"));
        	_usuario.setResposta(usuario.get("resposta"));
          	 usuarioRepositorio.save(_usuario);
    	}else {
    		_usuario = null;
    	}
    	return _usuario;
    }
	
	@CrossOrigin
    @PostMapping("/recuperar")
    public Usuario recuperar(@RequestParam Map<String, String> usuario ){
    	Usuario _usuario = new Usuario();
    	_usuario = usuarioRepositorio.findByEmailPerguntaResposta(usuario.get("email"), usuario.get("pergunta"), usuario.get("resposta")).stream().findFirst().orElse(null);
    	if(_usuario != null) {
        	_usuario.setEmail(usuario.get("email"));
        	_usuario.setSenha(usuario.get("senha"));
          	 usuarioRepositorio.save(_usuario);
    	}else {
    		_usuario = null;
    	}
    	return _usuario;
    }
	
}
			