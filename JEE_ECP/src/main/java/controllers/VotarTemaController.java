package controllers;

import models.entities.TemaEntity;
import models.utils.Studies;

public interface VotarTemaController {

	public void run(String ipUser, Double vote, Studies studies, TemaEntity tema);

}
