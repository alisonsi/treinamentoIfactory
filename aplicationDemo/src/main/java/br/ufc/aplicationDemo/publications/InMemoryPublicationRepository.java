package br.ufc.aplicationDemo.publications;

import br.ufc.aplicationDemo.authors.Author;
import br.ufc.aplicationDemo.publishers.Publisher;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Alisonsi on 18/07/2017.
 */
@Component
public class InMemoryPublicationRepository implements PublicationsRepository{
    private  static  final List<Publication> PUBLICATION = new ArrayList<>();



    static {
        PUBLICATION.addAll(Arrays.asList(
                new Publication(new Author(1,"Alison","Santos"),new Publisher(1,"Alison","Santos"),"Treinamento", 1, "artigo", "Treinamento abordando Spring boot")
                )
        );
    }

    @Override
    public boolean save(Publication publication) {
        boolean condition = PUBLICATION.contains(publication);
        System.out.println(condition);
        if(condition){
            return false;
        }else
            PUBLICATION.add(publication);
        return true;

    }

    @Override
    public Iterable<Publication> findAll() {
        return Collections.unmodifiableList(PUBLICATION);
    }

    @Override
    public Publication findOne(int codePublication) {
        for (Publication publication: PUBLICATION) {
            if(publication.getCode().equals(codePublication)){
                return publication;
            }

        }
        return null;
    }

    @Override
    public Publication delete(int codePublication) {
        int index = PUBLICATION.indexOf(findOne(codePublication));
        return  PUBLICATION.remove(index);

    }

    @Override
    public Publication update(int codePublication, Publication publication) {
        if(publication == null){
            throw new IllegalArgumentException("Sua publicação nao pode ser nula");
        }
        Publication selectPublication = findOne(codePublication);

        selectPublication.setPublisher(publication.getPublisher());
        selectPublication.setAuthor(publication.getAuthor());
        selectPublication.setTitle(publication.getTitle());
        selectPublication.setType(publication.getType());
        selectPublication.setDescription(publication.getDescription());

        int index = PUBLICATION.indexOf(selectPublication);

        PUBLICATION.set(index,selectPublication);

        return selectPublication;
    }

    @Override
    public Iterable<Publication> findPublicationsOfAuthor(int idAuthor) {

        Collection<Publication> publications = PUBLICATION
                .stream()
                .filter(c -> c.getAuthor().equals(idAuthor))
                .collect(Collectors.toList());

        return publications;
    }
}
