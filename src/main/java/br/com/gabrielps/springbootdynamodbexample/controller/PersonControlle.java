package br.com.gabrielps.springbootdynamodbexample.controller;

import br.com.gabrielps.springbootdynamodbexample.entity.Person;
import br.com.gabrielps.springbootdynamodbexample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person/")
public class PersonControlle {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public Person savePerson(@RequestBody  Person person){
        return personRepository.addPerson(person);
    }

    @GetMapping("{personId}")
    public Person getPerson(@PathVariable("personId") String personId){
        return personRepository.findById(personId);
    }

    @DeleteMapping
    public String deletePerson(@RequestBody  Person person){
        personRepository.deletePerson(person);
        return "Person Deleted";
    }





}
