package entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String surname;
	private LocalDate dateofbirth;
	private int cardnumber;
	
	@OneToMany(mappedBy = "user") //the mappedBy refers to the property of the parent object
	private List<Loan> loan; //loan is the secondary object
	
	public User(String name, String surname, LocalDate dateofbirth, int cardnumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.dateofbirth = dateofbirth;
		this.cardnumber = cardnumber;
	}
}