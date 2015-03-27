package controllers.ejbs;

import models.daos.jpa.DaoJpaFactory;
import controllers.DeleteTemaController;

public class DeleteTemaControllerEjb implements DeleteTemaController {

	DeleteTemaControllerEjb(){
		
	}

	@Override
	public void run(int id) {
		DaoJpaFactory.getFactory().getTemaDao().deleteById(id);;
	}
}
