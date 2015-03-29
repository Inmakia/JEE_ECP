package views.beans;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import models.daos.DaoFactory;
import models.daos.jpa.DaoJpaFactory;
import models.entities.TemaEntity;
import controllers.DeleteTemaController;
import controllers.ejbs.ControllerEjbFactory;

@ManagedBean
public class DeleteTemaViewBean {
	
	@ManagedProperty(value="#{id}")
	private Integer id;
	@ManagedProperty(value="#{tema}")
	private TemaEntity tema;
	@ManagedProperty(value="#{perm}")
	private String perm;
	private static final String TRUE = "666";
	@ManagedProperty(value="#{temas}")
	private TemasViewBean temasViewBean;
	
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
    	DaoFactory.setFactory(new DaoJpaFactory());
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
