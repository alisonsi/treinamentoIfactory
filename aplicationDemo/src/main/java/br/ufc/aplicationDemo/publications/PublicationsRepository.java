package br.ufc.aplicationDemo.publications;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Alisonsi on 18/07/2017.
 */
public interface PublicationsRepository extends CrudRepository<Publication, Integer> {

//    boolean save(Publication publication); // insert
//    Iterable<Publication> findAll(); // select all
//
//    Publication findOne(int codePublication); // select one
//    Publication delete(int codePublication); // delete
//    Publication update(int codePublication, Publication publication); // update
//    Iterable<Publication> findPublicationsOfAuthor(int idAuthor);
}
