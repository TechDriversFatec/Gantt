package com.spring.gantt.GanttBubbleSort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import com.spring.gantt.GanttBubbleSort.projeto.Projeto;
import com.spring.gantt.GanttBubbleSort.projeto.ProjetoController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.spring.gantt.GanttBubbleSort.tarefa.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class IndexController {

	@Autowired
	TarefaController tc = new TarefaController();

	@Autowired
	ProjetoController pc = new ProjetoController();

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/ganttTasks")
	public String ganttTasks(@RequestParam(name = "name", required = false, defaultValue = "World") final String name,
			final Model model) {

		final ArrayList<Tarefa> tarefas = new ArrayList<>();
		final ArrayList<Projeto> projetos = new ArrayList<>();

		// tc.getAllTarefas();
		tarefas.addAll(tc.getAllTarefas());
		projetos.addAll(pc.getAllProjetos());

		// Projeto p1 = new Projeto(10, "Projeto Webbot", "12-06-2020", 0, "project");
		// Projeto p2 = new Projeto(20, "Projeto Necto - Gantt", "14-06-2020", 0,
		// "project");

		// Projects proj1 = new Projects(10, "Projeto Webbot", "12-06-2020", 0,
		// "project");
		// Projects proj2 = new Projects(20, "Projeto Necto - Gantt", "14-06-2020", 0,
		// "project");
		// Tarefa t1 = new Tarefa("Criar documentação de requisitos!", 3, 10);
		// Tarefa t2 = new Tarefa("Primeira Implementação!", 6, 10);
		// Tarefa t3 = new Tarefa("Pesquisa", 2, 10);

		// Tarefa t4 = new Tarefa("Criar documentação de requisitos!", 3, 20);
		// Tarefa t5 = new Tarefa("Primeira Implementação!", 3, 20);

		// // Tasks task1 = new Tasks(1, "Criar documentação de requisitos!",
		// "12-06-2020", "14-06-2020", 2, 10);
		// // Tasks task2 = new Tasks(2, "Primeira Implementação!", "15-06-2020",
		// "17-06-2020", 4, 10);
		// // Tasks task3 = new Tasks(3, "Criar documentação de requisitos!",
		// "14-06-2020", "17-06-2020", 1, 20);
		// // Tasks task4 = new Tasks(4, "Primeira Implementação!", "20-06-2020",
		// "25-06-2020", 6, 20);

		// // model.addAttribute("p1", p1); // Atributos da view
		// // model.addAttribute("p2", p2); // Atributos da view
		// model.addAttribute("t1", t1); // Atributos da view
		// model.addAttribute("t2", t2); // Atributos da view
		// model.addAttribute("t3", t3); // Atributos da view
		// model.addAttribute("t4", t4); // Atributos da view
		model.addAttribute("tarefas", tarefas);
		model.addAttribute("projetos", projetos);

		// return "ganttTasks";
		return "loop";
	}

	@PostMapping(value = "/salvar")
	public ResponseEntity<Object> salvar(@RequestBody String formData) throws IOException {
    	
		System.out.println(formData);
		
		Files.write(Paths.get("C:/temp/test.txt"), formData.getBytes(), StandardOpenOption.APPEND);
    	
    	return new ResponseEntity<Object>(formData, HttpStatus.OK);
    }


}
