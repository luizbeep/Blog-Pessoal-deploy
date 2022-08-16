package com.blogpessoal.repository;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTeste {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {
		
		usuarioRepository.deleteAll();
		usuarioRepository.save(new Usuario(0L,"teste","teste@teste.com","12345678","url"));
		usuarioRepository.save(new Usuario(0L,"teste","teste@teste2.com","12345678","url"));
		usuarioRepository.save(new Usuario(0L,"teste","teste@teste3.com","12345678","url"));
		usuarioRepository.save(new Usuario(0L,"teste","teste@teste4.com","12345678","url"));
		
		
	}
	
	@Test
	@DisplayName("Retorna 1 Usuario")
	public void deveretornarUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("teste@teste.com");
		assertTrue (usuario.get().getUsuario().equals("teste@teste.com"));
		
	}
}
