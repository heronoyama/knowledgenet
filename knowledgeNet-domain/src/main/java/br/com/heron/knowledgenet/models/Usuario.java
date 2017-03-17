package br.com.heron.knowledgenet.models;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.Table;

@Table("user")
@BelongsTo(parent = Role.class, foreignKeyName = "id_role")
public class Usuario extends Model {

	public Usuario(){}
	
	public Usuario(String nome, String email,String senha){
		set("nome",nome);
		set("email",email);
		if(senha != null)
			set("senha",senha);
	}
	
	public static Usuario loga(String nome, String email){
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = Usuario.find("nome = ? and email = ?",nome,email).include(Role.class);
		assert usuarios.size() <= 1;
		
		if(usuarios.size() == 0){
			Usuario novoUsuario = new Usuario(nome,email,null);
			novoUsuario.saveIt();
			
			Role.getRoleDefault().add(novoUsuario);
			return novoUsuario;
		}
		return usuarios.get(0);
	}

	public String toJson(){
		Map<String,Object> map = super.toMap();
		map.remove("id_role");
		map.put("role",getRole().nome());
		
		try {
			return new ObjectMapper().writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
			return "{}";
		}
	}
	
	public Role getRole() {
		return parent(Role.class);
	}
	
}