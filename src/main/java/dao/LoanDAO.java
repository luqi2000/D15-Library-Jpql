package dao;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entities.Loan;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LoanDAO {
	private final EntityManager em;
	
	public LoanDAO(EntityManager em) {
		this.em = em;
	}
	//method save
	public void save(Loan l) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();//the operations that I want to do in the database starting
		em.persist(l);//it will save in the database what I pass
		transaction.commit();//terminate the transaction and flush the object
		log.info("Catalog saved");
	}
	
	//method getByid
	public Loan getById(String id) {
		Loan found = em.find(Loan.class, UUID.fromString(id));
		if (found != null) {
			log.info("Successfully found");
		} else {
			log.info("catalog not found");
		}
		return found;
	}
	
	//method delete
	public void FindAndDelete(long id) {
		Loan found = em.find(Loan.class, id);
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
	
