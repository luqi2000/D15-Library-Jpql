package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "magazines")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Magazines extends LibraryCatalog{
	private Periods period;
	

	public Magazines(String title, int yearPublication, int pageNumber, Periods period) {
		super(title, yearPublication, pageNumber);
		this.period = period;
	}	
}
