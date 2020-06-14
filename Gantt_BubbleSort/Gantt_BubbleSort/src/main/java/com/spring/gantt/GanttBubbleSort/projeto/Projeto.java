package com.spring.gantt.GanttBubbleSort.projeto;

import java.util.ArrayList;
import javax.persistence.*;
import com.spring.gantt.GanttBubbleSort.tarefa.Tarefa;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int projetoID;
    private String projetoName;
    
    // @OneToMany
    // private ArrayList<Tarefa> tarefas;

    public void setProjetoID(int id) {
        this.projetoID = id;
    }

    public int getProjetoId() {
        return this.projetoID;
    }

    public String getprojetoName() {
        return this.projetoName;
    }

    public void setProjetoName(String name) {
        this.projetoName = name;
    }

    public Projeto(int id, String name) {
        this.projetoID = id;
        this.projetoName = name;
    }

    public Projeto(int id) {
        this.projetoID = id;
    }

    public Projeto() {}

    public String toString() {
      return String.format(
          "Projeto[projetoID=%d, projetoName='%s']",
          projetoID, projetoName);
    } 
}