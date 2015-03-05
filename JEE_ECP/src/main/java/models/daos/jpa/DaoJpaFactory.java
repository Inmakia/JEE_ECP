package models.daos.jpa;

import javax.persistence.EntityManagerFactory;

public class DaoJpaFactory {
	private static final String PERSISTENCE_UNIT = "jee_ecp";
	
	private static EntityManagerFactory entityManagerFactory;
	
	public DaoJpaFactory() {
	}
	
	
}
