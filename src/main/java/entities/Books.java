package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Books extends LibraryCatalog{
	 String author;
	 String genre;
	 
	 //costructor
	public Books(String title, int yearPublication, int pageNumber, String author, String genre) {
		super( title, yearPublication, pageNumber);
		this.author = author;
		this.genre = genre;
	}
}
