package dao;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entities.Magazines;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class MagazinesDAO {
	private final EntityManager em;
	
	public MagazinesDAO(EntityManager em) {
		this.em = em;
	}
	
	//method save
	public void save(Magazines m) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();//the operations that I want to do in the database starting
		em.persist(m);//it will save in the database what I pass
		transaction.commit();//terminate the transaction and flush the object
		log.info("Catalog saved");
	}
	
	//method getByid
	public Magazines getById(String id) {
		Magazines found = em.find(Magazines.class, UUID.fromString(id));
		if (found != null) {
			log.info("Magazines Successfully found: " + found);
		} else {
			log.info("catalog not found");
		}
		return found;
	}
	
	//method delete
	public void FindAndDelete(String id) {
		Magazines found = em.find(Magazines.class, UUID.fromString(id));
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
