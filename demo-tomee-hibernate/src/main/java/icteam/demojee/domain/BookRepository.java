package icteam.demojee.domain;

import java.util.List;

/**
 * Represents a <a href="http://en.wikipedia.org/wiki/Domain-driven_design" target="_top" >REPOSITORY</a> of books.
 */
public interface BookRepository {

	/**
	 * Add the specified book to the repository.
	 * 
	 * @param book a book
	 */
	void addBook(Book book);

	/**
	 * Returns all books found in this repository.
	 * 
	 * @return all books found in this repository
	 */
	List<Book> getAllBooks();

}
