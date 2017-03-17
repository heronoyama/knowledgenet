package br.com.heron.knowledgenet.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;
import org.javalite.activejdbc.Model;

import com.google.common.base.Joiner;
import com.google.inject.Singleton;

@Singleton
public class JSONConverter {

	public String convert(Model model) throws JsonProcessingException, IOException {
		String jsonString = model.toJson(false);
		return jsonString;
	}


	public String convert(List<? extends Model> models) throws JsonProcessingException, IOException {
		List<String> objectsToString = new ArrayList<>();
		for (Model model : models){
			objectsToString.add(model.toJson(false));
		}
		String join = Joiner.on(",").join(objectsToString);
		return "["+join+"]";
	}
	
	

}
