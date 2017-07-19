package br.ufc.aplicationDemo.publishers;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alisonsi on 18/07/2017.
 */

public class InMemoryPublisherRepository {
//    private  static  final List<Publisher> PUBLISHERS = new ArrayList<>();
//
//    static {
//        PUBLISHERS.addAll(Arrays.asList(
//                new Publisher(123,"Publisher One", "Alison")
//                )
//        );
//    }
//
//    @Override
//    public boolean save(Publisher publisher) {
//        boolean condition = PUBLISHERS.contains(publisher);
//        System.out.println(condition);
//        if(condition){
//            return false;
//        }else
//            PUBLISHERS.add(publisher);
//        return true;
//    }
//
//    @Override
//    public Iterable<Publisher> findAll() {
//        return Collections.unmodifiableList(PUBLISHERS);
//
//    }
//
//    @Override
//    public Publisher findOne(int ENI) {
//        for (Publisher publisher: PUBLISHERS) {
//            if(publisher.getENI().equals(ENI)){
//                return publisher;
//            }
//
//        }
//        return null;
//    }
//
//    @Override
//    public Publisher delete(int ENI) {
//        int index = PUBLISHERS.indexOf(findOne(ENI));
//        return  PUBLISHERS.remove(index);
//    }
//
//    @Override
//    public Publisher update(int ENI, Publisher publisher) {
//        if(publisher == null){
//            throw new IllegalArgumentException("Sua editora nao pode ser nula");
//        }
//        Publisher selectedPublisher = findOne(ENI);
//
//        selectedPublisher.setName(publisher.getName());
//        selectedPublisher.setDirector(publisher.getDirector());
//
//        int index = PUBLISHERS.indexOf(selectedPublisher);
//
//        PUBLISHERS.set(index,selectedPublisher);
//
//        return selectedPublisher;
//    }
}
