package common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPSUtils {
	private static EntityManagerFactory factory;
	static public EntityManager getEntityManager() {
		if(factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("Assignmentjava4");
		}
		return factory.createEntityManager();
	}
	static public void closeConnect() {
		if (factory!=null && factory.isOpen()) {
			factory.close();
		}
	}
}
