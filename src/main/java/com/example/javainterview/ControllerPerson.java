package com.example.javainterview;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: marowak
 * Date: 22.06.2022
 * Time: 0:07
 */
@Service
public class ControllerPerson {

    private RepositoryPerson repositoryPerson = PersonRepositoryFactory.getPerson();

    @RequestMapping(value = "/api/v1/person", method = RequestMethod.POST)
    public Person getPerson(@RequestBody PersonRequest personRequest) {
        return repositoryPerson.getById(Long.parseLong(personRequest.id));
    }


    @RequestMapping(value = "/api/v1/personAnLogTime", method = RequestMethod.POST)
    public Person getPersonAnLogTime(@RequestBody PersonRequest personRequest) {
        long start = new Date().getTime();
        Person person = repositoryPerson.getById(Long.parseLong(personRequest.id));
        long stop = new Date().getTime() - start;
        System.out.println("Total time: " + (start - stop));

        return person;
    }
}
