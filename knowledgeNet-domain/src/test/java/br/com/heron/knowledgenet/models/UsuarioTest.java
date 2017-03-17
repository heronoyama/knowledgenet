package br.com.heron.knowledgenet.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest extends BDTest{

	
	@Before
	public void setup(){
		super.setup();
		new Role("Aluno").saveIt();
	}
	
	@Test
	public void loga_UsuarioExistente(){
		Usuario existente = new Usuario("Heron","email@email","admin");
		existente.saveIt();
		Role.getRoleDefault().add(existente);
		
		Usuario user = Usuario.loga("Heron", "email@email");
		assertNotNull(user);
		assertEquals("Heron",user.getString("nome"));
		assertEquals("email@email",user.getString("email"));
		assertEquals("Aluno",user.getRole().nome());
		
	}
	
	@Test
	public void loga_UsuarioNaoExistente(){
		Usuario user = Usuario.loga("Heron", "email@email");
		assertNotNull(user);
		assertEquals("Heron",user.getString("nome"));
		assertEquals("email@email",user.getString("email"));
		assertEquals("Aluno",user.getRole().nome());
	}
	
	@Test
	public void autenticaComRole(){
		Usuario user = new Usuario("Heron","email@email.com","admin");
		user.saveIt();
		
		Role role = new Role("Teste");
		role.saveIt();
		
		role.add(user);
		
		Role roleBuscado = user.parent(Role.class);
		
		assertEquals("Teste",roleBuscado.getString("nome"));
	}
	
	@Test
	public void generatedJson(){
		Usuario usuario = Usuario.loga("Heron", "email@email");
		
		String expected = "{\"email\":\"email@email\",\"id\":1,\"nome\":\"Heron\",\"role\":\"Aluno\"}";
		String actual = usuario.toJson();
		assertEquals(expected,actual);
	}

}