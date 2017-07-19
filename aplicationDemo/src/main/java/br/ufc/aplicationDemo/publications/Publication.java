package br.ufc.aplicationDemo.publications;

import br.ufc.aplicationDemo.authors.Author;
import br.ufc.aplicationDemo.publishers.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Alisonsi on 18/07/2017.
 */
@Data
@Entity
@AllArgsConstructor
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Publisher publisher;

    private String title;

    @Enumerated(EnumType.STRING)
    private PublicationType type;

    private String description;

//
//    public Publication(Author author, Publisher publisher, String title, Integer id, String type, String description) {
//        this.author = author;
//        this.publisher = publisher;
//        this.title = title;
//        this.id = id;
//        this.type = type;
//        this.description = description;
//    }
//
//    public Publication() {    }
//
//    public Author getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Author author) {
//        this.author = author;
//    }
//
//    public Publisher getPublisher() {
//        return publisher;
//    }
//
//    public void setPublisher(Publisher publisher) {
//        this.publisher = publisher;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publication that = (Publication) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
