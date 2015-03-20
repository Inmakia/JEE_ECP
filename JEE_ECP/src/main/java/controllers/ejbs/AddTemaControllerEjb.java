package controllers.ejbs;

import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.TemaEntity;
import controllers.AddTemaController;

public class AddTemaControllerEjb implements AddTemaController {
	

	@Override
	public void run(String nombre, String pregunta) {
		DaoJpaFactory.getFactory().getTemaDao().create(new TemaEntity(nombre, pregunta));;
	}
	

}
