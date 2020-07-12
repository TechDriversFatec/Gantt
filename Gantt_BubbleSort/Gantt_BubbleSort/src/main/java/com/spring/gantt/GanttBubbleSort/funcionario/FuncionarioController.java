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
    public @ResponseBody String addFunc(@RequestParam String nome,
            @RequestParam String Ncadastro) {

		Funcionario func = new Funcionario(nome,Ncadastro);
		
		funcionarioRepository.save(func);
		return "Saved";
	}
}
