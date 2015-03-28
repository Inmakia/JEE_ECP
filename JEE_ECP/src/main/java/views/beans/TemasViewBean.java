package views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import models.daos.jpa.DaoJpaFactory;
import models.entities.TemaEntity;

@ManagedBean
@RequestScoped
public class TemasViewBean {
	
	@ManagedProperty(value="#{temas}")
	private List<TemaEntity> temas;
	
	@PostConstruct
	public void update() {
		this.setTemas(DaoJpaFactory.getFactory().getTemaDao().findAll());
	}

	public List<TemaEntity> getTemas() {
		return temas;
	}

	public void setTemas(List<TemaEntity> temas) {
		this.temas = temas;
	}
}
