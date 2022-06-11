package br.com.udemy.services;

import br.com.udemy.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    public Person create(Person person) {
        return person;
    }

    public Person update(Person person) {
        return person;
    }

    public void delete(String id) {

    }

    public Person findById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Diego");
        person.setLastName("Silva");
        person.setAddress("BSB");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            persons.add(mockPerson(i));
        }

        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name" + i);
        person.setLastName("Last name" + i);
        person.setAddress("Some address" + i);
        person.setGender("Male");
        return person;
    }
}
