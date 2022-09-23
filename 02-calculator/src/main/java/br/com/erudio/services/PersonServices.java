package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Udemy conta: alexfarw@gmail.com
 * curso Microsserviços do 0 com Spring Cloud, Spring Boot e Docker
 * 09/23/2022
 *
 * @PersonServices implementa mock methods para responder ás chamadas HTTP
 * dos principais verbos mapeados em @PersonControler
 *
 */
@Service
public class PersonServices {
    private AtomicLong counter = new AtomicLong();

    public Person findById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Ale");
        person.setLastName("Faria");
        person.setAddress("Rua JLR,154");
        return person;
    }

    public ArrayList<Person> findByAll() {
        ArrayList<Person> persons = new ArrayList<>(10);
        for (int i = 0; i < 11; i++) {
            Person person = new Person();
            person.setId(counter.incrementAndGet());
            person.setFirstName("Ale");
            person.setLastName("Faria");
            person.setAddress("Rua JLR,154");
            person.setGender("Male");
            persons.add(person);
            System.out.println("new person id " + person.getId());
        }
        return persons;
    }

    public Person create(Person person) {
        person.setId(counter.incrementAndGet());
        return person;
    }

    public Person update(String id, Person person) {
        long l = Long.parseLong(id);
        person.setId(l);
        return person;
    }

    public String delete(String id) {
        return String.format("Deleted id %s with success", id);
    }
}
