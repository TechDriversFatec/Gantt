package com.spring.gantt.GanttBubbleSort.projeto;
import javax.persistence.*;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private String text;
	private String start_date;
	private String end_date;
	private int progress;
	private String type;
	
	public Projeto(){}

	public Projeto(String text){
		this.text = text;
	}

	public Projeto(int id, String text, String start_date, String end_date, int progress, String type) {
		super();
		this.id = id;
		this.text = text;
		this.start_date = start_date;
		this.progress = progress;
		this.type = type;
    }
    
    public Projeto(String text, String start_date, String end_date, int progress, String type) {
		this.text = text;
		this.start_date = start_date;
		this.progress = progress;
		this.type = type;
	}
	
	public Projeto(String text, String start_date, int progress, String type) {
		this.text = text;
		this.start_date = start_date;
		this.progress = progress;
		this.type = type;
    }
        
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}