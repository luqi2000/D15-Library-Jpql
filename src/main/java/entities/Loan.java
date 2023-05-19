package entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Loan {
	@Id
	@GeneratedValue
	private UUID id;
	private LocalDate startofdateloan;
	private LocalDate expecteddatareturnloan;
	private LocalDate effectivereturndate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")// set the name of the fk anyway default was aswell user_id
	private User user;
	
	@ManyToOne
	private LibraryCatalog loancatalog; //in default will be loancatalog_id
	
	public Loan(User user, LibraryCatalog loancatalog, LocalDate startofdateloan, LocalDate expecteddatareturnloan, LocalDate effectivereturndate) {
		super();
		this.user = user;
		this.loancatalog = loancatalog;
		this.startofdateloan = startofdateloan;
		this.expecteddatareturnloan = expecteddatareturnloan;
		this.effectivereturndate = effectivereturndate;
	}
	
}

