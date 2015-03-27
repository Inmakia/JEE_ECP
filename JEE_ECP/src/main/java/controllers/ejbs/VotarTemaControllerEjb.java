package controllers.ejbs;

import models.daos.jpa.DaoJpaFactory;
import models.entities.TemaEntity;
import models.entities.VotoEntity;
import models.utils.Studies;
import controllers.VotarTemaController;

public class VotarTemaControllerEjb implements VotarTemaController {

	public VotarTemaControllerEjb() {
		
	}

	@Override
	public void run(String ipUser, Double vote, Studies studies, TemaEntity tema) {
		DaoJpaFactory.getFactory().getVotoDao().create(new VotoEntity(ipUser, vote, studies, tema));		
	}
}
