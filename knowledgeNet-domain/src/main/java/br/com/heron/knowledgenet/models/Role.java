package br.com.heron.knowledgenet.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("role")
public class Role extends Model{
	
	public Role(){}
	
	public Role(String nome){
		set("nome",nome);
	}
	
	public static Role getRoleDefault(){
		Role role = Role.findFirst("nome = ?", "Aluno");
		//TODO
		if(role == null){
			role = new Role("Aluno");
			role.saveIt();
		}
		return role;
	}

	public String nome() {
		return getString("nome");
	}

}
