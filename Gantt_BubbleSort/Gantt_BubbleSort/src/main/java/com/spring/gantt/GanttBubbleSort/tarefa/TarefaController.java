package com.spring.gantt.GanttBubbleSort.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/tarefa")
public class TarefaController {
    
    @Autowired

    private TarefaRepository tarefaRepository;

    @PostMapping(path="/addTarefa") 
    public @ResponseBody String addNewUser (@RequestParam String desc,
                                            @RequestParam int duracao,
                                            @RequestParam int idProjeto) {

      Tarefa ta = new Tarefa(desc, duracao, idProjeto);

      tarefaRepository.save(ta);
      return "Tarefa inserida";
    }

    @GetMapping(path="/getTarefas")
    public @ResponseBody Iterable<Tarefa> getAllTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping(path="/getProjetoTarefas")
    public @ResponseBody Iterable<Tarefa> getProjetoTarefas(@RequestParam int idProjeto) {
        return tarefaRepository.findByProjetoProjetoID(idProjeto);
    }
}