package views.beans;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import models.daos.jpa.DaoJpaFactory;
import models.entities.TemaEntity;
import models.utils.Studies;
import controllers.VotarTemaController;
import controllers.ejbs.ControllerEjbFactory;

@ManagedBean
public class VotarTemaViewBean {
	
	@ManagedProperty(value="#{id}")
	private Integer id;
	@ManagedProperty(value="#{ipUser}")
	private String ipUser;
	@ManagedProperty(value="#{vote}")
	private Double vote;
	@ManagedProperty(value="#{studies}")
	private Studies studies;
	@ManagedProperty(value="#{studiesOptions}")
	private Studies[] studiesOptions;
	@ManagedProperty(value="#{tema}")
	private TemaEntity tema;
	@ManagedProperty(value="#{temas}")
	private TemasViewBean temasViewBean;
	
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
	
	public TemasViewBean getTemasViewBean() {
		return temasViewBean;
	}

	public void setTemasViewBean(TemasViewBean temasViewBean) {
		this.temasViewBean = temasViewBean;
	}

	@PostConstruct
	public void updateJsf() {
		if (temasViewBean.getId() != null) {
			this.setId(Integer.parseInt(temasViewBean.getId()));
		} else if (this.id == null) {
			Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			this.setId(Integer.parseInt(params.get("id")));
		}
		update();
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
