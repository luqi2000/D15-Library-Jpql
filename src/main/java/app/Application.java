package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import utils.JpaUtil;

public class Application {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
	}

}
