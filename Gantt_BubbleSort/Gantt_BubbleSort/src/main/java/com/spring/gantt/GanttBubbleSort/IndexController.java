package com.spring.gantt.GanttBubbleSort;

import java.io.IOException;

import com.spring.gantt.GanttBubbleSort.link.LinkController;
import com.spring.gantt.GanttBubbleSort.projeto.ProjetoController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.spring.gantt.GanttBubbleSort.tarefa.*;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@Autowired
	TarefaController tc = new TarefaController();

	@Autowired
	ProjetoController pc = new ProjetoController();

	@Autowired
	LinkController lc = new LinkController();
	
	@PostMapping(value = "/salvar")
	public ResponseEntity<Object> salvar(@RequestBody final String formData) throws IOException {
		
		final JSONObject obj = new JSONObject(formData);

		//Files.write(Paths.get("C:/temp/test.txt"), obj.toString().getBytes(), StandardOpenOption.APPEND);
		// JSONArray arr = obj.getJSONArray("posts");
		for (int i = 0; i < obj.getJSONArray("data").length(); i++) {
			if (obj.getJSONArray("data").getJSONObject(i).getString("type").equals("project")) {
				pc.addProjeto(obj.getJSONArray("data").getJSONObject(i).getInt("id"),
						  	  obj.getJSONArray("data").getJSONObject(i).getString("text"),
						  	  obj.getJSONArray("data").getJSONObject(i).getString("start_date"),
						  	  obj.getJSONArray("data").getJSONObject(i).getString("end_date"),
						  	  obj.getJSONArray("data").getJSONObject(i).getInt("progress"),
						  	  obj.getJSONArray("data").getJSONObject(i).getInt("parent"),
						  	  obj.getJSONArray("data").getJSONObject(i).getInt("duration"),
						  	  obj.getJSONArray("data").getJSONObject(i).getString("priority"),
						  	  obj.getJSONArray("data").getJSONObject(i).getString("type"));
			} else if (obj.getJSONArray("data").getJSONObject(i).getString("type").equals("task")) {
				tc.addNewTask(obj.getJSONArray("data").getJSONObject(i).getInt("id"),
						 	  obj.getJSONArray("data").getJSONObject(i).getString("text"),
						 	  obj.getJSONArray("data").getJSONObject(i).getString("start_date"),
						 	  obj.getJSONArray("data").getJSONObject(i).getString("end_date"),
						 	  obj.getJSONArray("data").getJSONObject(i).getInt("progress"),
							  obj.getJSONArray("data").getJSONObject(i).getString("parent"),
							  obj.getJSONArray("data").getJSONObject(i).getInt("duration"),
							  obj.getJSONArray("data").getJSONObject(i).getString("priority"),
							  obj.getJSONArray("data").getJSONObject(i).getString("type"), "" );
							//   obj.getJSONArray("data").getJSONObject(i).getJSONObject(1));
			} else if (obj.getJSONArray("data").getJSONObject(i).getString("type").equals("milestone")) {
				tc.addNewTask(obj.getJSONArray("data").getJSONObject(i).getInt("id"),
						 	  obj.getJSONArray("data").getJSONObject(i).getString("text"),
						 	  obj.getJSONArray("data").getJSONObject(i).getString("start_date"),
						 	  obj.getJSONArray("data").getJSONObject(i).getString("end_date"),
						 	  obj.getJSONArray("data").getJSONObject(i).getInt("progress"),
							  obj.getJSONArray("data").getJSONObject(i).getString("parent"),
							  obj.getJSONArray("data").getJSONObject(i).getInt("duration"), "",
							  obj.getJSONArray("data").getJSONObject(i).getString("type"), "" );
			}
		}

		for (int i = 0; i < obj.getJSONArray("links").length(); i++)
		{
			lc.addLink(obj.getJSONArray("links").getJSONObject(i).getInt("id"),
					   obj.getJSONArray("links").getJSONObject(i).getString("source"),
					   obj.getJSONArray("links").getJSONObject(i).getString("target"),
					   obj.getJSONArray("links").getJSONObject(i).getString("type"));
		}
    	
    	return new ResponseEntity<Object>(formData, HttpStatus.OK);
    }


}
