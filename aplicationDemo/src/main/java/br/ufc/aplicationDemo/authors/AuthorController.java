package br.ufc.aplicationDemo.authors;
import br.ufc.aplicationDemo.publications.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Alisonsi on 17/07/2017.
 */
@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @RequestMapping(
            method = RequestMethod.GET
    )
    @ResponseBody
    public ResponseEntity<Iterable<Author>> queryAllAuthors(){
        return ResponseEntity.ok(repository.findAll());
        //retorna todos os autores

    }
    @RequestMapping(
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) throws MalformedURLException, URISyntaxException{
        //cria um autor
        int status;
        boolean created = repository.save(author);
        if(created){
            status = 201;
        }else{
            status = 409;
        }
        System.out.println(created);
        URI location = new URI("http://localhost:8080/authors/"+author.getId());


        return ResponseEntity.status(status).location(location)
                .build();

    }
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            produces = "application/json"
    )
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable("id") Integer id ){
        //atualiza um autor
        int status;

        Author authorUpdate = repository.update(id, author);
        if(authorUpdate!=null){
            status = 201;
        }else{
            status = 400;
        }

        return ResponseEntity.status(status).body(authorUpdate);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<Author> findOneAuthor(@PathVariable("id") Integer id ){

        int status = 200;
        Author author = repository.findOne(id);
        if(author == null){
            status = 404;
        }

        return ResponseEntity.status(status).body(author);
    }


    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json"
    )
    public ResponseEntity<Author> deleteAuthor(@PathVariable("id") Integer id ){
        //Deletando um autor
        int status = 200;
        Author author = repository.delete(id);
        if(author == null){
            status = 404;
        }

        return ResponseEntity.status(status).body(author);
    }

    @RequestMapping(
            value = "{id}/publications",
            method = RequestMethod.GET
    )
    public ResponseEntity<Iterable<Publication>> findPublicationsOfAuthor(@PathVariable("id") Integer idAuthor){
        return ResponseEntity.ok(repository.findPublicationsOfAuthor(idAuthor));
    }
}
