package dao;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Books;
import entities.LibraryCatalog;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LibraryCatalogDAO {
	private final EntityManager em;
	
	public LibraryCatalogDAO(EntityManager em) {
		this.em = em;
	}
	
	//method save
	public void save(LibraryCatalog n) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();//the operations that I want to do in the database starting
		em.persist(n);//it will save in the database what I pass
		transaction.commit();//terminate the transaction and flush the object
		log.info("Catalog saved");
	}
	
	//method getByid
	public LibraryCatalog getById(String id) {
		LibraryCatalog found = em.find(LibraryCatalog.class, UUID.fromString(id));
		if (found != null) {
			log.info("Successfully found");
		} else {
			log.info("catalog not found");
		}
		return found;
	}
	
	//method delete
	public void FindAndDelete(long id) {
		LibraryCatalog found = em.find(LibraryCatalog.class, id);
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
	
	//find by Year of pubblication
	public LibraryCatalog findByYearPubblication(int yearpublication){
		TypedQuery<LibraryCatalog> query = em.createNamedQuery("LibraryCatalog.findByYearPubblication", LibraryCatalog.class)
	        .setParameter("yearpublication", yearpublication);
		return query.getSingleResult();
	}
	
	public Books findByAuthor(String author){
		TypedQuery<Books> query = em.createNamedQuery("Books.findByAuthor" , Books.class);
		query.setParameter("author", author);
		return query.getSingleResult();
	}
	
	public LibraryCatalog findByTitle(String title) {
		TypedQuery<LibraryCatalog> query = em.createNamedQuery("LibraryCatalog.findByTitle", LibraryCatalog.class);
		query.setParameter("title", title);
		return query.getSingleResult();
	}
}
	
