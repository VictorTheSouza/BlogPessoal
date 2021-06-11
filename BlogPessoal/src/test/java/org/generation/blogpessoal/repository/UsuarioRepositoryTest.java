package org.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.blogpessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	public void start() {
		usuarioRepository.deleteAll();
		
		Usuario usuario = new Usuario();
		usuario.setNome("Victor");
		usuario.setUsuario("victor@hotmail.com");
		usuario.setSenha("123456");
		
		
		if(usuarioRepository.findByUsuario("victor.souza@hotmail.com").isEmpty()) {
			usuarioRepository.save(usuario);
		}
		
		usuario = new Usuario();
		usuario.setNome("Victor");
		usuario.setUsuario("victor@hotmail.com");
		usuario.setSenha("123456");
		
		if(usuarioRepository.findByUsuario("victor.gonçalves@hotmail.com").isEmpty()) {
			usuarioRepository.save(usuario);
		}
		
		usuario = new Usuario();
		usuario.setNome("Victor");
		usuario.setUsuario("victor@hotmail.com");
		usuario.setSenha("123456");
		
		if(usuarioRepository.findByUsuario("vinicios.souza@hotmail.com").isEmpty()) {
			usuarioRepository.save(usuario);
		}
		
		usuario = new Usuario();
				usuario.setNome("Victor");
		usuario.setUsuario("victor@hotmail.com");
		usuario.setSenha("123456");
		
		if(usuarioRepository.findByUsuario("vinicios.gonçalves@hotmail.com").isEmpty()) {
			usuarioRepository.save(usuario);
		}
		
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void testFindByUsuario() throws Exception {
		Optional<Usuario> usuario;
		
		usuario = usuarioRepository.findByUsuario("victor@hotmail.com");
		
		assertTrue(usuario.get().getUsuario().equals("victor@hotmail.com"));
	}
	
	@Test
	public void testFindAllIgnoringCase() throws Exception {
		List<Usuario> usuario = usuarioRepository.findAllByNomeContainingIgnoreCase("Victor");
		
		assertEquals(4, usuario.size());
		
	}
	
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
	
	
}
