package dao;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entities.User;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class UserDAO {
	private final EntityManager em;
	
	public UserDAO(EntityManager em) {
		this.em = em;
	}
	
	//method save
	public void save(User u) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();//the operations that I want to do in the database starting
		em.persist(u);//it will save in the database what I pass
		transaction.commit();//terminate the transaction and flush the object
		log.info("Catalog saved");
	}
	
	//method getByid
	public User getById(String id) {
		User found = em.find(User.class, UUID.fromString(id));
		if (found != null) {
			log.info("Successfully found");
		} else {
			log.info("catalog not found");
		}
		return found;
	}
	
	//method delete
	public void FindAndDelete(long id) {
		User found = em.find(User.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			log.info(id + "Succesfull deleted");
		}else {
			log.info("id not found");
		}
	}
}
	
