package com.spring.gantt.GanttBubbleSort.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/projeto")
public class ProjetoController {
    @Autowired

    private ProjetoRepository projetoRepository;

    @PostMapping(path="/addProjeto") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name) {
      // @ResponseBody means the returned String is the response, not a view name
      // @RequestParam means it is a parameter from the GET or POST request
  
      Projeto pr = new Projeto();
      pr.setProjetoName(name);
      projetoRepository.save(pr);
      return "Saved";
    }

    @GetMapping(path="/getProjetos")
    public @ResponseBody Iterable<Projeto> getAllProjetos() {
        // This returns a JSON or XML with the users
        return projetoRepository.findAll();
    }

    @RequestMapping("/teste")
	public String index() {
		return "index";
	}
}