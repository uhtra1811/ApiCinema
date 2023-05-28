package com.cinema.ApiCinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cinema.ApiCinema.model.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
		List<Usuario> findByEmail(String email);
		
		@Query("SELECT u FROM Usuario u WHERE u.email = ?1 AND u.senha = ?2")
		List<Usuario> findByEmailAndSenha(String email, String senha);
		
		
		@Query("SELECT u FROM Usuario u WHERE u.email = ?1 AND u.pergunta = ?2 AND u.resposta = ?3")
		List<Usuario> findByEmailPerguntaResposta(String email, String pergunta, String resposta);
		
}
