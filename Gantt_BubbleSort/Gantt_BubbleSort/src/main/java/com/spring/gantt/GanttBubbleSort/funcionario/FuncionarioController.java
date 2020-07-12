package com.spring.gantt.GanttBubbleSort.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gantt.GanttBubbleSort.projeto.Projeto;
import com.spring.gantt.GanttBubbleSort.projeto.ProjetoRepository;

@RestController
public class FuncionarioController {
	
    @Autowired
    private FuncionarioRepository  funcionarioRepository;
	
    @PostMapping("/addFunc")
    public @ResponseBody String addFunc(@RequestParam int id, @RequestParam String nome) {
    	
    	System.out.println(nome);
    	
		Funcionario func = new Funcionario(0,nome);
		
		funcionarioRepository.save(func);
		return "Saved";
	}
}
