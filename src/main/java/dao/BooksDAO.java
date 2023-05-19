package dao;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entities.Books;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BooksDAO {
	private final EntityManager em;
	
	public BooksDAO(EntityManager em) {
		this.em = em;
	}
	
	//method save
	public void save(Books b) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();//the operations that I want to do in the database starting
		em.persist(b);//it will save in the database what I pass
		transaction.commit();//terminate the transaction and flush the object
		log.info("catalogo salvato");
	}
	
	//method getByid
	public Books getById(String id) {
		Books found = em.find(Books.class, UUID.fromString(id));
		if (found != null) {
			log.info("Successfully found");
		} else {
			log.info("catalog not found");
		}
		return found;
	}
	
	//method delete
	public void FindAndDelete(long id) {
		Books found = em.find(Books.class, id);
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