package br.com.heron.knowledgenet.models;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;

public abstract class BDTest {
	
	//TODO - configurar hsqldb
	
	@Before
	public void setup(){
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/knowledge_net", "root", "");
		
		cleanup();
	}
	
	@After
	public void setDown(){
		cleanup();
		Base.close();
	}
	
	private void cleanup() {
		Base.exec("DELETE FROM user");
		Base.exec("ALTER TABLE user AUTO_INCREMENT = 1");
		Base.exec("DELETE FROM role");
		Base.exec("ALTER TABLE role AUTO_INCREMENT = 1");
	}

}
