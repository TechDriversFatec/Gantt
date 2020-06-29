package com.spring.gantt.GanttBubbleSort.projeto;

import java.util.ArrayList;

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
    public @ResponseBody String addProjeto (@RequestParam String text,
                                            @RequestParam String start_date,
                                            @RequestParam String end_date,
                                            @RequestParam int progress,
                                            @RequestParam String type) {
  
      Projeto projeto = new Projeto(text, start_date, progress, type);
      projetoRepository.save(projeto);
      return "Saved";
    }

    public String addTestString (String text) {
      Projeto projeto = new Projeto(text);
      projetoRepository.save(projeto);
      return "Saved";
    }

    @GetMapping(path="/getProjetos")
    public @ResponseBody ArrayList<Projeto> getAllProjetos() {
        return projetoRepository.findAll();
    }

}