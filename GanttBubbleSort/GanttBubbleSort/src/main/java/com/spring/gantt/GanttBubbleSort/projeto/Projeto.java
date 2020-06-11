package com.spring.gantt.GanttBubbleSort.projeto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int projetoID;
    private String projetoName;

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

    public Projeto() {}

    public String toString() {
      return String.format(
          "Projeto[projetoID=%d, projetoName='%s']",
          projetoID, projetoName);
    } 
}