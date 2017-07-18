package br.ufc.aplicationDemo.publications;

import br.ufc.aplicationDemo.publishers.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        boolean created = repository.save(publication);
        if(created){
            status = 201;
        }else{
            status = 400;
        }
        System.out.println(created);
        URI location = new URI("http://localhost:8080/authors/" + publication.getCode());


        return ResponseEntity.status(status).location(location)
                .build();

    }
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ResponseEntity<Iterable <Publication>> findAll(){

        return ResponseEntity.ok(repository.findAll());
    }
}
