package views.beans;

import controllers.AddTemaController;
import controllers.ejbs.ControllerEjbFactory;

public class AddTemaViewBean {
	
	private String nombre;
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
