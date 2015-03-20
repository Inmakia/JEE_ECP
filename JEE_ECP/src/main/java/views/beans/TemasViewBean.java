package views.beans;

import java.util.List;

import models.daos.jpa.DaoJpaFactory;
import models.entities.TemaEntity;

public class TemasViewBean {

	private List<TemaEntity> temas;
	
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
