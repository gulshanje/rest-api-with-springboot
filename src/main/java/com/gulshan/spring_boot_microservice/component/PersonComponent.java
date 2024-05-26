package com.gulshan.spring_boot_microservice.component;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.gulshan.spring_boot_microservice.pojo.Person;
import com.gulshan.spring_boot_microservice.service.PersonService;

@Component
public class PersonComponent {
    @Autowired
    PersonService personService;

    public Person getPerson(String firstName, String lastName, Optional<String> age) {
        Integer personAge = personService.getAge(age);
        return personService.getService(personAge, firstName, lastName);

    }

}
