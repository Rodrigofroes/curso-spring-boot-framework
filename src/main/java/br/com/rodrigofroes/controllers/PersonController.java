package br.com.rodrigofroes.controllers;

import br.com.rodrigofroes.models.Person;
import br.com.rodrigofroes.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        this.personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id){
        return this.personService.findById(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return this.personService.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        return this.personService.update(person);
    }
}
