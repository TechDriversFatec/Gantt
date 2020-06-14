package com.spring.gantt.GanttBubbleSort.tarefa;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import com.spring.gantt.GanttBubbleSort.tarefa.Tarefa;

public interface TarefaRepository extends CrudRepository<Tarefa, Integer>{
    
    ArrayList<Tarefa> findByProjetoProjetoID(int projetoID);
    
}