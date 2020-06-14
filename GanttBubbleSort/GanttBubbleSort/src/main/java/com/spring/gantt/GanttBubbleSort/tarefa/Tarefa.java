package com.spring.gantt.GanttBubbleSort.tarefa;

import javax.persistence.*;
import com.spring.gantt.GanttBubbleSort.projeto.Projeto;

@Entity
public class Tarefa {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int tarefaID;
    private int duracaoDias;
    private String descricao;
    
    @ManyToOne
    private Projeto projeto;

    public void setDescricao(String desc) {
        this.descricao = desc;
    }

    public void setDuracaoDias(int duracao){
        this.duracaoDias = duracao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public int getTarefaID() {
        return this.tarefaID;
    }

    public int getDuracaoDias(){
        return this.duracaoDias;
    }

    public void setprojeto(int projetoID){
        this.projeto = new Projeto(projetoID);
    }

    public Tarefa() {}

    public Tarefa(String descricao, int duracaoDias, int projetoID) {
        this.descricao = descricao;
        this.duracaoDias = duracaoDias;
        this.projeto = new Projeto(projetoID);
    }

}