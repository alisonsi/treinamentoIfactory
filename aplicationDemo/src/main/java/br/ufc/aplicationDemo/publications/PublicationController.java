package br.ufc.aplicationDemo.publications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Alisonsi on 18/07/2017.
 */
@RestController
@RequestMapping("/publication")
public class PublicationController {

    @Autowired
    private PublicationsRepository repository;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public ResponseEntity<Void> create(@RequestBody Publication publication) throws URISyntaxException{
        int status;
       Object created = repository.save(publication);
        if(created!=null){
            status = 201;
        }else{
            status = 409;
        }
        URI location = new URI("http://localhost:8080/publication/" + publication.getId());


        return ResponseEntity.status(status).location(location)
                .build();

    }
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ResponseEntity<Iterable <Publication>> findAll(){

        return ResponseEntity.ok(repository.findAll());
    }

//    @RequestMapping(
//            value = "/{id}",
//            method = RequestMethod.PUT
//    )
//    public ResponseEntity<Publication> updateAuthor(@RequestBody Publication publication, @PathVariable("id") Integer id ){
//
//        int status = 201;
//
//        Publication publicationUpdate = repository.update(id, publication);
//        if(publicationUpdate==null){
//            status = 404;
//        }
//
//        return ResponseEntity.status(status).body(publicationUpdate);
//    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Publication> findOnePublication(@PathVariable("id") Integer id ){

        int status = 200;
        Publication publication = repository.findOne(id);
        if(publication == null){
            status = 404;
        }

        return ResponseEntity.status(status).body(publication);
    }


    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<Publication> deleteAuthor(@PathVariable("id") Integer id ){
        //Deletando um autor
        int status = 200;
        repository.delete(id);
        return ResponseEntity.accepted().build();
    }


}
