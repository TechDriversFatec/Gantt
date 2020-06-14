package com.spring.gantt.GanttBubbleSort;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
public class IndexController {
	
	// ProjetoDao projetoService;
	// Projeto testeProjeto = new Projeto(1, "Teste1");

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/ganttTasks")
	public String ganttTasks(@RequestParam(name="name", required=false, defaultValue="World") 
	String name, Model model) {
		
		Projects proj1 = new Projects(10, "Projeto Webbot", "12-06-2020", 0, "project");
		Projects proj2 = new Projects(20, "Projeto Necto - Gantt", "14-06-2020", 0, "project");
		
		Tasks task1 = new Tasks(1, "Criar documentação de requisitos!", "12-06-2020", "14-06-2020", 0, 10);
		Tasks task2 = new Tasks(2, "Primeira Implementação!", "15-06-2020", "17-06-2020", 0, 10);
		Tasks task3 = new Tasks(3, "Criar documentação de requisitos!", "14-06-2020", "17-06-2020", 0, 20);
		Tasks task4 = new Tasks(4, "Primeira Implementação!", "20-06-2020", "25-06-2020", 0, 20);
		
		model.addAttribute("proj1", proj1); // Atributos da  view
		model.addAttribute("proj2", proj2); // Atributos da  view
		model.addAttribute("task1", task1); // Atributos da  view
		model.addAttribute("task2", task2); // Atributos da  view
		model.addAttribute("task3", task3); // Atributos da  view
		model.addAttribute("task4", task4); // Atributos da  view
		
		return "ganttTasks";
	}
	


	@GetMapping("/greeting")
	public String greeting(
							@RequestParam(name="name", required=false, defaultValue="World") 
							String name, Model model
							) {
		 model.addAttribute("name", "Omae wa"); // Atributos da  view
		 model.addAttribute("teste123", "Mon shin deiru"); // Atributos da  view
		return "greeting"; // -> Nome da view
	}

	@GetMapping("/greeting2")
	public String greeting2(
							@RequestParam(name="name", required=false, defaultValue="World") 
							String name, Model model
							) {
		 model.addAttribute("name", "Omae wa"); // Atributos da  view
		 model.addAttribute("teste123", "Mon shin deiru"); // Atributos da  view
		 model.addAttribute("isTrue", true); // Atributos da  view
		return "greeting2"; // -> Nome da view
	}

	// @PostMapping(value = "/findAll")
	// public void createProjeto(@RequestBody Employee emp) {
	// 	projetoService.insertEmployee(emp);
	// }

	// @GetMapping(value = "/projetoList")
	// 	public List<Projeto> getProjetos() {
	// 	return projetoService.findAll();
	// }

	// @PostMapping(value = "/createProjeto")
    // public void createProjeto(@RequestBody Projeto prj) {
    //     projetoService.insertProjeto(emp);
    // }

}
