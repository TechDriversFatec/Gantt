package com.spring.gantt.GanttBubbleSort.projeto;

import java.util.List;
import javax.persistence.*;
import com.spring.gantt.GanttBubbleSort.tarefa.Tarefa;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String start_date;
	private int progress;
	private String type;
        
    // List<Tarefa> tarefas;

    // @OneToMany(mappedBy = "projeto", targetEntity = Tarefa.class, fetch=FetchType.LAZY)
    // @JoinColumn(name="tarefa_id")
    // public List<Tarefa> getTarefas() {
    //     return tarefas;
    // }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart_date() {
		return this.start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public int getProgress() {
		return this.progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

    public Projeto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Projeto(String name, String start_date, int progress, String type) {
        this.name = name;
        this.start_date = start_date;
        this.progress = progress;
        this.type = type;
    }

    public Projeto(int id, String name, String start_date, int progress, String type) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.progress = progress;
        this.type = type;
    }

    public Projeto(int id) {
        this.id = id;
    }

    public Projeto() {}

    // public void addTarefa(Tarefa t){
    //     this.tarefas.add(t);
    // }

    // public String toString() {
    //   return String.format(
    //       "Projeto[projetoID=%d, projetoName='%s']",
    //       projetoID, projetoName);
    // } 
}