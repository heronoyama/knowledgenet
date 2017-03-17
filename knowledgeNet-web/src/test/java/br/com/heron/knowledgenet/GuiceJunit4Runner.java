package br.com.heron.knowledgenet;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import br.com.heron.knowledgenet.app.ApplicationListener;

public class GuiceJunit4Runner extends BlockJUnit4ClassRunner{

	public GuiceJunit4Runner(Class<?> klass) throws InitializationError {
		super(klass);
	}
	
	  @Override
	    public Object createTest() throws Exception {
	        Object object = super.createTest();
	        new ApplicationListener().getInjector().injectMembers(object);
	        return object;
	    }
	  //TODO another applicationlistener para testes 

}
