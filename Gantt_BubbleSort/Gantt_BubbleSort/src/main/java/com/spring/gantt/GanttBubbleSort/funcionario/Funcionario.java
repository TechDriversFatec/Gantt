package com.spring.gantt.GanttBubbleSort.funcionario;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcionario {
	
    @Id
	private String nome;
	private String Ncadastro;
	
	public Funcionario(){}
	
	public Funcionario(String nome, String Ncadastro) {
		super();
		this.nome = nome;
		this.Ncadastro = Ncadastro;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCadastro() {
		return Ncadastro;
	}
	public void setCadastro(String Ncadastro) {
		this.Ncadastro = Ncadastro;
	}
}
