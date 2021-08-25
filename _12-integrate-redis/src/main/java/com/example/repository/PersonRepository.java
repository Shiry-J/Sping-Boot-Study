package com.example.repository;

import com.example.domain.Person;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person,String> {

    @Override
    <S extends  Person>S save(S entity);

    Optional<Person> findPersonByFirstName(String firstName);

}
