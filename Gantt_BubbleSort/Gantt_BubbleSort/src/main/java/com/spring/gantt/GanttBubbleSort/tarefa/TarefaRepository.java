package com.spring.gantt.GanttBubbleSort.tarefa;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import com.spring.gantt.GanttBubbleSort.tarefa.Tarefa;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.Query;

public interface TarefaRepository extends CrudRepository<Tarefa, Integer>{
    
    ArrayList<Tarefa> findByProjeto_id(int ID);

    @Query(nativeQuery = true, value = "SELECT * FROM tarefa WHERE projeto_id = 8;")
    ArrayList<Tarefa> findtarefas();
    
}