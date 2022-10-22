package com.example.demo.person;

import com.surrealdb.driver.SyncSurrealDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private SyncSurrealDriver surreal;

    public List<Person> getAll() {
        return surreal.select("person", Person.class);
    }

    public Person createNew(NewPersonDto dto) {
        Person newPerson = new Person();
        newPerson.setName(dto.getName());
        newPerson.setAge(dto.getAge());

        return surreal.create("person", newPerson);
    }
}
