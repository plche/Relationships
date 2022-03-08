package com.codingdojo.peru.ft2022.relationships.services;

import com.codingdojo.peru.ft2022.relationships.models.License;
import com.codingdojo.peru.ft2022.relationships.models.Person;
import com.codingdojo.peru.ft2022.relationships.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> allPersons() {
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person findPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) return optionalPerson.get();
        else return null;
    }

    public Person updatePerson(Long id, String firstName, String lastName, License license) {
        Person person = new Person(firstName, lastName, license);
        person.setId(id);
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {personRepository.deleteById(id);}
}
