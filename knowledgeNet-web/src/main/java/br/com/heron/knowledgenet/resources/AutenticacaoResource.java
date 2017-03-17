package br.com.heron.knowledgenet.resources;

import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import br.com.heron.knowledgenet.controllers.AutenticacaoController;
import br.com.heron.knowledgenet.models.Usuario;

@Singleton
@Path("/oauth")
public class AutenticacaoResource {
	
	@Inject
	private AutenticacaoController controller;
	
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(JsonNode object) throws JsonProcessingException, IOException{
		String email = object.get("email").asText();
		String nome = object.get("name").asText();
		Usuario usuario = controller.loga(nome,email);
		if(usuario != null)
			return Response.ok(usuario.toJson()).build();
		return Response.status(401).build();
		
	}
	
	@POST
	@Path("/logout")
	public Response logout(JsonNode object){
		String email = object.get("email").asText();
		String senha = object.get("senha").asText();
		
		return Response.status(401).build();
		
	}
	

}
