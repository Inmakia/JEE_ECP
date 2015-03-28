package controllers.ejbs;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controllers.AddTemaController;
import controllers.ControllerFactory;
import controllers.DeleteTemaController;
import controllers.ViewVotesController;
import controllers.VotarTemaController;

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory {
	
	private AddTemaController addTemaController;
	private DeleteTemaController deleteTemaController;
	private ViewVotesController viewVotesController;
	private VotarTemaController votarController;
	
	public static ControllerEjbFactory factory;
	
	public static void setFactory(ControllerEjbFactory factory) {
		ControllerEjbFactory.factory = factory;
	}
	
	public static ControllerEjbFactory getFactory() {
		if (ControllerEjbFactory.factory == null) {
			return new ControllerEjbFactory();
		}
		return ControllerEjbFactory.factory;
	}
	
	public ControllerEjbFactory(){
	}
	
	@Override
	public VotarTemaController getVotarController() {
		if (votarController == null) {
			votarController = new VotarTemaControllerEjb();
		}
		return votarController;
	}

	@Override
	public ViewVotesController getViewVotesController() {
		if (viewVotesController == null) {
			viewVotesController = new ViewVotesControllerEjb();
		}
		return viewVotesController;
	}

	@Override
	public AddTemaController getAddTemaController() {
		if (addTemaController == null) {
			addTemaController = new AddTemaControllerEjb();
		}
		return addTemaController;
	}

	@Override
	public DeleteTemaController getDeleteController() {
		if (deleteTemaController == null) {
			deleteTemaController = new DeleteTemaControllerEjb();
		}
		return deleteTemaController;
	}

}
