package br.com.erudio.controller;

import br.com.erudio.exception.UnsupportedMathOperationException;
import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static br.com.erudio.request.converters.ConverterUtils.isNumeric;

/**
 *  Udemy conta: alexfarw@gmail.com
 *  curso Microsserviços do 0 com Spring Cloud, Spring Boot e Docker
 *  09/23/2022
 *
 *  aprendendo sobre os verbos HTTP mais usados GET, POST, PUT, DELETE
 *  como fazer as chamadas no POSTMAN
 */
@RestController
@RequestMapping(value = "/person")
public class PersonControler {
    @Autowired
    PersonServices personServices;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person listaPerson(@PathVariable("id") String id) {
        if ( !isNumeric(id)) {
            throw new UnsupportedMathOperationException("Please set a valid integer number!");
        }
        return (personServices.findById(id) );
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> listaAll() {
        return (personServices.findByAll() );
    }

    @RequestMapping(method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return (personServices.create(person) );
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@PathVariable("id") String id, @RequestBody Person person) {
        return (personServices.update(id, person) );
    }

    @RequestMapping(value = "/{id}",
                    method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id) {
        return personServices.delete(id);
    }
}
