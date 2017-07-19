package br.ufc.aplicationDemo.publishers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Alisonsi on 18/07/2017.
 */
@RestController
@RequestMapping("/publisher")
public class PublisherController {


    @Autowired
    private PublisherRepository repository;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public ResponseEntity<Void> create(@RequestBody Publisher publisher) throws URISyntaxException {
        int status;
        Object created = repository.save(publisher);
        if(created != null){
            status = 201;
        }else{
            status = 409;
        }
        URI location = new URI("http://localhost:8080/publication/" + publisher.getENI());


        return ResponseEntity.status(status).location(location)
                .build();

    }
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ResponseEntity<Iterable <Publisher>> findAll(){

        return ResponseEntity.ok(repository.findAll());
    }

//    @RequestMapping(
//            value = "/{id}",
//            method = RequestMethod.PUT
//    )
//    public ResponseEntity<Publisher> updatePublisher(@RequestBody Publisher publisher, @PathVariable("id") Integer id ){
//
//        int status = 201;
//
//        Publisher publisherUpdate = repository.update(id, publisher);
//        if(publisherUpdate == null){
//            status = 404;
//        }
//
//        return ResponseEntity.status(status).body(publisherUpdate);
//    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Publisher> findOnePublisher(@PathVariable("id") Integer id ){

        int status = 200;
        Publisher publisher = repository.findOne(id);
        if(publisher == null){
            status = 404;
        }

        return ResponseEntity.status(status).body(publisher);
    }


    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<Publisher> deletePublisher(@PathVariable("id") Integer id ){
        int status = 200;
        repository.delete(id);


        return ResponseEntity.accepted().build();
    }



}
