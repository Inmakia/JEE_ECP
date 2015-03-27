package views.beans;

import models.daos.jpa.DaoJpaFactory;
import models.entities.TemaEntity;
import controllers.DeleteTemaController;
import controllers.ejbs.ControllerEjbFactory;

public class DeleteTemaViewBean {

	private Integer id;
	private TemaEntity tema;
	private String perm;
	private static final String TRUE = "666";
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TemaEntity getTema() {
		return tema;
	}
	public void setTema(TemaEntity tema) {
		this.tema = tema;
	}
	public String getPerm() {
		return perm;
	}
	public void setPerm(String perm) {
		this.perm = perm;
	} 
	
	public void update() {
		this.setTema(DaoJpaFactory.getFactory().getTemaDao().read(id));
	}
	
	public String process() {
		if (this.perm.equals(TRUE)) {
			DeleteTemaController controller = ControllerEjbFactory.getFactory().getDeleteController();
			controller.run(id);
		}
		return "home";		
	}
}
