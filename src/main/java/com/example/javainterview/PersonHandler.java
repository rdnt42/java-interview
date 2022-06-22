package com.example.javainterview;

import com.example.javainterview.entity.Address;
import com.example.javainterview.entity.Person;
import com.example.javainterview.helpers.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: marowak
 * Date: 22.06.2022
 * Time: 0:07
 */
@Controller
public class PersonHandler {

    private final RepositoryPerson repositoryPerson = PersonRepositoryFactory.getPerson();
    private final RepositoryAddress repositoryAddress = AddressRepositoryFactory.getRepositoryAddress();


    // запрашивает пользователя по id
    @PostMapping(value = "/api/v1/person")
    @ResponseBody
    public Person getPerson(@RequestBody Request request) {
        return repositoryPerson.getById(Long.parseLong(request.getId()));
    }

    // запрашивает пользователя по id и показывает время выполнения метода
    @GetMapping(value = "/api/v1/personAnLogTime")
    public Person getPersonAnLogTime() {
        long start = new Date().getTime();
        Person person = repositoryPerson.getById(1L);
        long stop = new Date().getTime() - start;
        System.out.println("Total time: " + (start - stop));

        return person;
    }

    // обновление времени последнего запроса
    @GetMapping("/api/v1/updateTimeForPerson")
    public Person getAndUpdate(@RequestBody Request request) {
        Person person = repositoryPerson.getById(Long.parseLong(request.getId()));
        person.setLastUpdate(new Date());

        return person;
    }


    // обновить данные
    @PostMapping("/api/v1/updatePersonOnAddress")
    @Transactional
    public Address updateAddress(@RequestBody Request request) {
        Address address = repositoryAddress.getById(request.getNewPersonId());
        updateAddress(address, request.getNewPersonId());
        address.getPerson().setLastUpdate(new Date());

        return address;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateAddress(Address address, Long personId) {
        address.setPersonId(personId);
    }
}
