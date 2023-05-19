package entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "libray_catalog")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class LibraryCatalog {
	
	//Attribute
	@Id
	@GeneratedValue
	private UUID id;
	protected String title;
	protected int yearPublication;
	protected int pageNumber;
	
	@OneToMany(mappedBy = "loancatalog")
	private List<Loan> loan;
	
	//costructor
	
	public LibraryCatalog(String title, int yearPublication, int pageNumber) {
		super();
		this.title = title;
		this.yearPublication = yearPublication;
		this.pageNumber = pageNumber;
	}
	public LibraryCatalog(String title, int yearPublication, int pageNumber, List<Loan> loan) {
		super();
		this.title = title;
		this.yearPublication = yearPublication;
		this.pageNumber = pageNumber;
		this.loan = loan;
	}
}
