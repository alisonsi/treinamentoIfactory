package br.ufc.aplicationDemo.publications;

import br.ufc.aplicationDemo.authors.Author;
import br.ufc.aplicationDemo.publishers.Publisher;

/**
 * Created by Alisonsi on 18/07/2017.
 */
public class Publication {
    private Author author;
    private Publisher publisher;
    private String title;
    private Integer code;
    private String type;
    private String description;

    public Publication(Author author, Publisher publisher, String title, Integer code, String type, String description) {
        this.author = author;
        this.publisher = publisher;
        this.title = title;
        this.code = code;
        this.type = type;
        this.description = description;
    }

    public Publication() {    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publication that = (Publication) o;

        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
