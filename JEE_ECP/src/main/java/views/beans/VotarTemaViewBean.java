package views.beans;

import models.daos.jpa.DaoJpaFactory;
import models.entities.TemaEntity;
import models.utils.Studies;
import controllers.VotarTemaController;
import controllers.ejbs.ControllerEjbFactory;

public class VotarTemaViewBean {
	
	private Integer id;
	private String ipUser;
	private Double vote;
	private Studies studies;
	private Studies[] studiesOptions;
	private TemaEntity tema;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getIpUser() {
		return ipUser;
	}
	
	public void setIpUser(String ipUser) {
		this.ipUser = ipUser;
	}
	
	public Double getVote() {
		return vote;
	}
	
	public void setVote(Double vote) {
		this.vote = vote;
	}
	
	public Studies getStudies() {
		return studies;
	}
	
	public void setStudies(Studies studies) {
		this.studies = studies;
	}
	
	public TemaEntity getTema() {
		return tema;
	}
	
	public void setTema(TemaEntity tema) {
		this.tema = tema;
	}

	public Studies[] getStudiesOptions() {
		return studiesOptions;
	}

	public void setStudiesOptions(Studies[] studiesOptions) {
		this.studiesOptions = studiesOptions;
	}
	
	public void update() {
		this.setStudiesOptions(Studies.values());
		this.setTema(DaoJpaFactory.getFactory().getTemaDao().read(id));
	}
	
	public String process() {
		VotarTemaController controller = ControllerEjbFactory.getFactory().getVotarController();
		controller.run(ipUser, vote, studies, tema);
		return "home";
	}
	
}
