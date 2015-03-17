package controllers.ejbs;

import javax.faces.bean.ManagedBean;

import controllers.AddTemaController;
import controllers.ControllerFactory;
import controllers.DeleteTemaController;
import controllers.ViewVotesController;
import controllers.VotarController;

@ManagedBean(name = "controllerFactory")
public class ControllerEjbFactory extends ControllerFactory {
	
	private AddTemaController addTemaController;
	private DeleteTemaController deleteTemaController;
	private ViewVotesController viewVotesController;
	private VotarController votarController;
	
	public ControllerEjbFactory(){
	}
	
	@Override
	public VotarController getVotarController() {
		if (votarController == null) {
			votarController = new VotarControllerEjb();
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
