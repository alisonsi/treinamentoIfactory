package br.ufc.aplicationDemo.authors;

/**
 * Created by Alisonsi on 17/07/2017.
 */
public interface AuthorRepository {

    Iterable<Author> findAll(); // select all
    boolean save(Author author); // insert
    Author delete(int author); // delete
    Author findOne(int idAuthor); // select one
    Author update(int idAuthor, Author author); // update authors

}