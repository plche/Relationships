package com.codingdojo.peru.ft2022.relationships.repositories;

import com.codingdojo.peru.ft2022.relationships.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
}
