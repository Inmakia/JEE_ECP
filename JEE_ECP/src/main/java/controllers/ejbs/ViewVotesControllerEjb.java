package controllers.ejbs;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.VotoDao;
import models.entities.TemaEntity;
import models.entities.VotoEntity;
import models.utils.Studies;
import controllers.ViewVotesController;

public class ViewVotesControllerEjb implements ViewVotesController {

	ViewVotesControllerEjb(){
		
	}

	@Override
	public Integer getVotos(TemaEntity tema) {
		int total = 0;
		VotoDao votoDao = DaoFactory.getFactory().getVotoDao();
		List<VotoEntity> votos = votoDao.findAll();
		for (VotoEntity voto : votos) {
			if (voto.getTema().equals(tema)) {
				total++;
			}
		}
		return total;
	}

	@Override
	public Double getMediaVotos(TemaEntity tema) {
		Double media = 0.0;
		int total = this.getVotos(tema);
		if (total != 0) {
			VotoDao votoDao = DaoFactory.getFactory().getVotoDao();
			List<VotoEntity> votos = votoDao.findAll();
			for (VotoEntity voto : votos) {
				if (voto.getTema().equals(tema)) {
					media = media + voto.getVote();
				}
			}
			media = media / total;
		}
		return media;
	}

	@Override
	public Double getMediaPorEstudios(TemaEntity tema, Studies studies) {
		Double media = 0.0;
		int total = 0;
		VotoDao votoDao = DaoFactory.getFactory().getVotoDao();
		List<VotoEntity> votos = votoDao.findAll();
		for (VotoEntity voto : votos) {
			if (voto.getTema().equals(tema) && voto.getStudies() == studies) {
				total++;
				media = media + voto.getVote();
			}
		}
		if (total != 0) {
			media = media / total;
		} else {
			media = 0.0;
		}
		return media;
	}
}
