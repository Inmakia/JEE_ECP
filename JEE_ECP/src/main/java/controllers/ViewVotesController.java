package controllers;

import models.entities.TemaEntity;
import models.utils.Studies;

public interface ViewVotesController {

	public Integer getVotos(TemaEntity tema);
	public Double getMediaVotos(TemaEntity tema);
	public Double getMediaPorEstudios(TemaEntity tema, Studies studies);
}
