package models.daos.jpa;

import models.daos.VotoDao;
import models.entities.VotoEntity;

public class VotoDaoJpa extends GenericDaoJpa<VotoEntity, Integer> implements VotoDao {

	public VotoDaoJpa() {
		super(VotoEntity.class);
	}

}
