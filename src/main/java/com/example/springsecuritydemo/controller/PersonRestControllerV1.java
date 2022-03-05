package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonRestControllerV1 {

    private List<Person> PERSONS = Stream.of(
            new Person(1L, "Ivan", "Ivanov"),
            new Person(2L, "Petr", "Petrov"),
            new Person(3L, "Vladimir", "Vladimirov")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Person> getAll() {
        return PERSONS;
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return PERSONS.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

}
