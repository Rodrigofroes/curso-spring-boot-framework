package br.com.rodrigofroes.service;

import br.com.rodrigofroes.Repository.PersonRepository;
import br.com.rodrigofroes.exception.ResourceNotFoundException;
import br.com.rodrigofroes.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public Person create(Person person) {
        logger.info("Creating a new person");
        return this.personRepository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating person with id: " + person.getId());

        Person entity = this.personRepository.findById(person.getId())
                .orElseThrow(() -> {
                    logger.severe("Person not found with id: " + person.getId());
                    return new ResourceNotFoundException("Person not found with id: " + person.getId());
                });

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        logger.info("Person updated successfully");
        return this.personRepository.save(entity);
    }

    public List<Person> findAll() {
        logger.info("Finding all persons");
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding person by id: " + id);
        return this.personRepository.findById(id)
                .orElseThrow(() -> {
                    logger.severe("Person not found with id: " + id);
                    return new ResourceNotFoundException("Person not found with id: " + id);
                });
    }

    public void delete(Long id) {
        logger.info("Deleting person by id: " + id);

        Person entity = this.personRepository.findById(id)
                .orElseThrow(() -> {
                    logger.severe("Person not found with id: " + id);
                    return new ResourceNotFoundException("Person not found with id: " + id);
                });

        this.personRepository.delete(entity);
    }

}
