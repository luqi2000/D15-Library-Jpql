package entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NamedQuery(name = "LibraryCatalog.findByYearPubblication", query = "SELECT l FROM LibraryCatalog l WHERE l.yearpublication = :yearpublication")
@NamedQuery(name = "LibraryCatalog.findByTitle", query = "SELECT t FROM LibraryCatalog t WHERE t.title LIKE CONCAT('%', :title, '%')")
@Table(name = "libray_catalog")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class LibraryCatalog {
	

	@Id
	@GeneratedValue
	private UUID id;
	protected String title;
	protected int yearpublication;
	protected int pagenumber;
	
	@OneToMany(mappedBy = "loancatalog")
	private List<Loan> loan;
	
	//costructor
	
	public LibraryCatalog(String title, int yearpublication, int pagenumber) {
		super();
		this.title = title;
		this.yearpublication = yearpublication;
		this.pagenumber = pagenumber;
	}
}
