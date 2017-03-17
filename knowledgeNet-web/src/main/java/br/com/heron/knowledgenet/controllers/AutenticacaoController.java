package br.com.heron.knowledgenet.controllers;

import com.google.inject.Singleton;

import br.com.heron.knowledgenet.models.Usuario;

@Singleton
public class AutenticacaoController {
	
	public Usuario loga(String nome, String email) {
		
		return Usuario.loga(nome, email);
	}

}
