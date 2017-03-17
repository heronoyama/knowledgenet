package br.com.heron.knowledgenet.app;

import java.util.Collections;
import java.util.List;

import com.google.inject.Module;
import com.google.inject.servlet.ServletModule;
import com.squarespace.jersey2.guice.JerseyGuiceServletContextListener;

public class ApplicationListener extends JerseyGuiceServletContextListener {

	@Override
	protected List<? extends Module> modules() {
		return Collections.singletonList(new ServletModule() {
			@Override
			protected void configureServlets() {
			}
		});
	}

}
