package models.entities;

import javax.persistence.*;

import models.utils.Studies;

@Entity
public class VotoEntity {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String ipUser;
	
	private Double vote;
	
	@Enumerated(EnumType.STRING)
	private Studies studies;
	
	@ManyToOne
	@JoinColumn
	private TemaEntity tema;
	
	public VotoEntity(String ipUser, Double vote, Studies studies, TemaEntity tema ) {
		this.setIpUser(ipUser);
		this.studies = studies;
		this.vote = vote;
		this.tema = tema;
	}
	
	public VotoEntity() {
		this(null, null, null, null);
	}

	public Integer getId() {
		return id;
	}
	
	public String getIpUser() {
		return ipUser;
	}
	
	public Double getVote() {
		return vote;
	}
	
	public Studies getStudies() {
		return studies;
	}
	
	public TemaEntity getTema() {
		return tema;
	}

	public void setIpUser(String ipUser) {
		this.ipUser = ipUser;
	}

	public void setVote(Double vote) {
		this.vote = vote;
	}

	public void setStudies(Studies studies) {
		this.studies = studies;
	}

	public void setTema(TemaEntity tema) {
		this.tema = tema;
	}

	@Override
	public String toString() {
		return "VotoEntity [id=" + id + ", ipUser=" + ipUser + ", vote=" + vote
				+ ", studies=" + studies + ", tema=" + tema + "]";
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof VotoEntity) {
			VotoEntity voto = (VotoEntity)obj;
			res = true;
			res = res && this.ipUser.equals(voto.ipUser);
			res = res && this.vote.equals(voto.vote);
			res = res && this.studies.equals(voto.studies);
			res = res && this.tema.equals(voto.tema);
		}
		return res;
	}
}
