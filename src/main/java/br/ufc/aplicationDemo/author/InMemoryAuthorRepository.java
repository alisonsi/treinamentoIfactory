package br.ufc.aplicationDemo.author;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Alisonsi on 17/07/2017.
 */
@Component
public class InMemoryAuthorRepository implements AuthorRepository{
    private  static  final List<Author> AUTHORS = new ArrayList<>();



    static {
        AUTHORS.addAll(Arrays.asList(
                new Author(1,"Alison", "santos"),
                new Author(2,"Joao", "santos")
            )
        );
    }

    @Override
    public Author delete(int idAutor) {

        int index = AUTHORS.indexOf(findOne(idAutor));
        return  AUTHORS.remove(index);
    }

    @Override
    public Author findOne(int idAuthor) {
        for (Author authors: AUTHORS) {
            if(authors.getId().equals(idAuthor)){
                return authors;
            }

        }
        return null;
    }

    @Override
    public Author update(int idAuthor, Author author) {
        if(author == null){
            throw new IllegalArgumentException("author nao pode ser nulo");
        }
        Author selectAuthor = findOne(idAuthor);

        selectAuthor.setFirstName(author.getFirstName());
        selectAuthor.setLastName(author.getLastName());

        int index = AUTHORS.indexOf(selectAuthor);

        AUTHORS.set(index,selectAuthor);

        return selectAuthor;
    }

    @Override
    public Iterable<Author> findAll(){
        return Collections.unmodifiableList(AUTHORS);

    }
    @Override
    public boolean save(Author author){
        boolean condition = AUTHORS.contains(author);
        System.out.println(condition);
        if(condition){
            return false;
        }else
        AUTHORS.add(author);
        return true;


    }

}
