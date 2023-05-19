package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import dao.LibraryCatalogDAO;
import dao.MagazinesDAO;
import dao.BooksDAO;
import dao.UserDAO;
import entities.Books;
import entities.Magazines;
import entities.Periods;
import entities.User;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManagerFactory;

import utils.JpaUtil;
@Slf4j
public class Application {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		
		//added User
		UserDAO ud = new UserDAO(em);
		User uno = new User("mario", "rossi", LocalDate.of(1997, 02, 05), 789787);
		//ud.save(uno); //if i leave double slash and run the app it will register user again in the database
		
		//Added books in books (table) and catalog (table) automatically thanks to pk and fk ->strategy: JOINED from LIbraryCatalog
		BooksDAO bd = new BooksDAO(em);
		Books first = new Books("all the light we cannot see", 1999, 206, "Anthony Doerr", "romance");
		//bd.save(first);
		
		//another book
		Books second = new Books("The mind of the leader", 2005, 243, "elon mask", "technology");
		//bd.save(second);
		
		//added magazines in magazines (table) and catalog (table) automatically thanks to pk and fk ->strategy: JOINED from LIbraryCatalog
		MagazinesDAO mz = new MagazinesDAO(em);
		Magazines firstmag= new Magazines("lord of asperity", 2005, 59, Periods.monthly);
		//mz.save(firstmag);
		
		//another magazines
		Magazines secondmag = new Magazines("gentleman", 2010, 22, Periods.weekly);
		//mz.save(secondmag);
		
		//find by Id
		mz.getById("4dd7daef-960f-49f1-bef6-70fa5e6f8148");
		
		//find & delete by Id
		mz.FindAndDelete("cd9ef77a-20b5-4edd-83c5-03bf2146e531"); //already cancel 1 time so next time when you run you will not find the id
		
		//search per year of publications
		LibraryCatalogDAO lc = new LibraryCatalogDAO(em);
		log.info(lc.findByYearPubblication(2010).toString());
		
		//search by Author from books
		log.info(bd.findByAuthor("Anthony Doerr").toString());
		log.info(lc.findByTitle("gentleman").toString());
		
	}

}
