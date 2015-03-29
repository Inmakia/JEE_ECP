package views.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import models.daos.DaoFactory;
import models.daos.jpa.DaoJpaFactory;
import models.entities.TemaEntity;

@ManagedBean(name="temas")
@RequestScoped
public class TemasViewBean {
	
	//@ManagedProperty(value="#{temas}")
	private List<TemaEntity> temas;
	private String id;
	
	@PostConstruct
	public void update() {
    	DaoFactory.setFactory(new DaoJpaFactory());
		this.setTemas(DaoJpaFactory.getFactory().getTemaDao().findAll());
	}

	public List<TemaEntity> getTemas() {
		return temas;
	}

	public void setTemas(List<TemaEntity> temas) {
		this.temas = temas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String deleteTema() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		this.setId(params.get("id"));
		return "deleteTema";
	}
	
	public String votarTema() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		this.setId(params.get("id"));
		return "votarTema";
	}
}
