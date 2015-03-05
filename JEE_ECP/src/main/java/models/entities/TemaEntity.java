package models.entities;

import javax.persistence.*;

@Entity
public class TemaEntity {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String question;
	
	public TemaEntity(String name, String question){
		this.setName(name);
		this.setQuestion(question);
	}
	
	public TemaEntity() {
		this(null, null);
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setQuestion (String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "TemaEntity [id=" + id + ", name=" + name + ", question="
				+ question + "]";
	}
	
	
}
