package br.ufc.aplicationDemo.publishers;

import br.ufc.aplicationDemo.publications.Publication;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Alisonsi on 18/07/2017.
 */
@Data
@Entity
@AllArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer ENI;

    private String name;

    private String director;

    @OneToMany(mappedBy = "publisher")
    private Collection<Publication> publications;

    public Publisher() {
    }
    //    public Publisher(Integer ENI, String name, String director) {
//        this.ENI = ENI;
//        this.name = name;
//        this.director = director;
//    }
//
//    public Publisher() {}
//
//    public Integer getENI() {
//        return ENI;
//    }
//
//    public void setENI(Integer ENI) {
//        this.ENI = ENI;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDirector() {
//        return director;
//    }
//
//    public void setDirector(String director) {
//        this.director = director;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return ENI.equals(publisher.ENI);
    }

    @Override
    public int hashCode() {
        return ENI.hashCode();
    }
}

