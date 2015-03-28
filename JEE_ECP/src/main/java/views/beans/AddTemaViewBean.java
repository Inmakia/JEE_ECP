package views.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import controllers.AddTemaController;
import controllers.ejbs.ControllerEjbFactory;

@ManagedBean
public class AddTemaViewBean {
	
	@ManagedProperty(value="#{nombre}")
	private String nombre;
	@ManagedProperty(value="#{pregunta}")
	private String pregunta;
	
	public AddTemaViewBean(){
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}


	public String process() {
		AddTemaController controller = ControllerEjbFactory.getFactory().getAddTemaController();
		controller.run(nombre, pregunta);
		return "home";		
	}
}
