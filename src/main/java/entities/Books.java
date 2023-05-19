package entities;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NamedQuery(name = "Books.findByAuthor", query = "SELECT b FROM Books b WHERE b.author = :author")
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Books extends LibraryCatalog{
	 String author;
	 String genre;
	 
	 //costructor
	public Books(String title, int yearpublication, int pagenumber, String author, String genre) {
		super( title, yearpublication, pagenumber);
		this.author = author;
		this.genre = genre;
	}
}