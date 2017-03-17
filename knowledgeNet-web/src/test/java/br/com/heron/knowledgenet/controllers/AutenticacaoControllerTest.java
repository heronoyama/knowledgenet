package br.com.heron.knowledgenet.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import br.com.heron.knowledgenet.BDTest;
import br.com.heron.knowledgenet.GuiceJunit4Runner;
import br.com.heron.knowledgenet.controllers.AutenticacaoController;
import br.com.heron.knowledgenet.models.Usuario;

@RunWith(GuiceJunit4Runner.class)
public class AutenticacaoControllerTest extends BDTest{

	@Inject
	private AutenticacaoController subject;
	

}
