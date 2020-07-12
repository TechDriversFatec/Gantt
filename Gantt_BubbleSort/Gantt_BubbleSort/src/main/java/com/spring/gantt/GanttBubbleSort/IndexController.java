package com.spring.gantt.GanttBubbleSort;

import java.io.IOException;

<<<<<<< HEAD
import com.spring.gantt.GanttBubbleSort.funcionario.FuncionarioController;
import com.spring.gantt.GanttBubbleSort.projeto.Projeto;
=======
import com.spring.gantt.GanttBubbleSort.link.LinkController;
>>>>>>> a6a1cf4946468ce38b86be73e879ebff0f79bf7b
import com.spring.gantt.GanttBubbleSort.projeto.ProjetoController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.spring.gantt.GanttBubbleSort.tarefa.*;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
=======
>>>>>>> a6a1cf4946468ce38b86be73e879ebff0f79bf7b
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
=======
>>>>>>> a6a1cf4946468ce38b86be73e879ebff0f79bf7b

@RestController
public class IndexController {

	@Autowired
	TarefaController tc = new TarefaController();

	@Autowired
	ProjetoController pc = new ProjetoController();

	@Autowired
	LinkController lc = new LinkController();
	
	@Autowired
	FuncionarioController fc = new FuncionarioController();
	
	@PostMapping(value = "/submitFunc")
	public ResponseEntity<Object> salvarFunc(@RequestBody final String funcData) throws IOException {
				
		final JSONObject obj = new JSONObject(funcData);
		
		for (int i = 0; i < obj.length(); i++) {
			fc.addFunc(obj.getString("nome"),
					   obj.getString("Ncadastro"));
		}
		
		return new ResponseEntity<Object>(funcData, HttpStatus.OK);
	}

	
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
