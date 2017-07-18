package br.ufc.aplicationDemo.publishers;

/**
 * Created by Alisonsi on 18/07/2017.
 */
public class Publisher {
    private Integer ENI;
    private String name;
    private String director;


    public Publisher(Integer ENI, String name, String director) {
        this.ENI = ENI;
        this.name = name;
        this.director = director;
    }

    public Publisher() {}

    public Integer getENI() {
        return ENI;
    }

    public void setENI(Integer ENI) {
        this.ENI = ENI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

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

