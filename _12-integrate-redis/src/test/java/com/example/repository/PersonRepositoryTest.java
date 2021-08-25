package com.example.repository;

import com.example.domain.Address;
import com.example.domain.Family;
import com.example.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void save() {
        Person person = new Person();
        person.setId("002");
        person.setLastName("Y");
        person.setFirstName("Shiry1");
        Address address = new Address();
        address.setNation("中国");
        address.setVillage("南京");
        person.setAddress(address);
        List<Family> familyList = new ArrayList<>();
        Family father = new Family();
        father.setType("father");
        father.setName("dad");
        Family mother = new Family();
        mother.setType("mother");
        mother.setName("mom");
        familyList.add(father);
        familyList.add(mother);
        person.setFamilyList(familyList);
        System.out.println("save--------->" + personRepository.save(person));
    }

    @Test
    void findPersonByFirstName() {
        Optional<Person> personByFirstName = personRepository.findPersonByFirstName("Shiry");
        if(personByFirstName.isPresent()){
            Person person = personByFirstName.get();
            System.out.println("person = " + person);
        }
    }
}