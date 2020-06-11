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
	public String ganttTasks() {
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
