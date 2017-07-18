package br.ufc.aplicationDemo.publishers;

/**
 * Created by Alisonsi on 18/07/2017.
 */
public interface PublisherRepository {

    boolean save(Publisher publisher); // insert
    Iterable<Publisher> findAll(); // select all

    Publisher findOne(int ENI); // select one
    Publisher delete(int ENI); // delete
    Publisher update(int ENI, Publisher publisher); // update

}
