package models.daos.jpa;

import models.daos.TemaDao;
import models.entities.TemaEntity;

public class TemaDaoJpa extends GenericDaoJpa<TemaEntity, Integer> implements TemaDao {

	public TemaDaoJpa() {
		super(TemaEntity.class);
	}


}
