package views.beans;

import models.daos.jpa.DaoJpaFactory;
import models.entities.TemaEntity;
import models.utils.Studies;
import controllers.ejbs.ControllerEjbFactory;

public class ViewVotesViewBean {
	
	private Integer id;
	private TemaEntity tema;
	private Integer total;
	private Double media;
	private Double mediaPorEstudios;
	private Studies studies;
	private Studies[] studiesOptions;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TemaEntity getTema() {
		return tema;
	}
	public void setTema(TemaEntity tema) {
		this.tema = tema;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Double getMedia() {
		return media;
	}
	public void setMedia(Double media) {
		this.media = media;
	}
	public Double getMediaPorEstudios() {
		return mediaPorEstudios;
	}
	public void setMediaPorEstudios(Double mediaPorEstudios) {
		this.mediaPorEstudios = mediaPorEstudios;
	}
	public Studies getStudies() {
		return studies;
	}
	public void setStudies(Studies studies) {
		this.studies = studies;
	}
	public Studies[] getStudiesOptions() {
		return studiesOptions;
	}
	public void setStudiesOptions(Studies[] studiesOptions) {
		this.studiesOptions = studiesOptions;
	}
	
	public void update() {
		this.setStudiesOptions(Studies.values());
		this.setTema(DaoJpaFactory.getFactory().getTemaDao().read(id));
		this.setMedia(ControllerEjbFactory.getFactory().getViewVotesController().getMediaVotos(tema));
		this.setTotal(ControllerEjbFactory.getFactory().getViewVotesController().getVotos(tema));
		if (this.studies != null) {
			this.setMediaPorEstudios(ControllerEjbFactory.getFactory().getViewVotesController().getMediaPorEstudios(tema, studies));
		}
	}
	
}
