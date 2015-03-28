package controllers.ejbs;

import models.daos.DaoFactory;
import models.daos.jpa.DaoJpaFactory;
import controllers.DeleteTemaController;

public class DeleteTemaControllerEjb implements DeleteTemaController {

	DeleteTemaControllerEjb(){
		
	}

	@Override
	public void run(int id) {
    	DaoFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.getFactory().getTemaDao().deleteById(id);;
	}
}
