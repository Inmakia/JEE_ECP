package models.daos;

public abstract class DaoFactory {
	public static DaoFactory factory = null;
	
	public static void setFactory(DaoFactory factory) {
		DaoFactory.factory = factory;
	}
	
	public static DaoFactory getFactory() {
		return DaoFactory.factory;
	}
}
