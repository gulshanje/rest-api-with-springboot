package com.gulshan.spring_boot_microservice.component;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gulshan.spring_boot_microservice.exception.SystemException;
import com.gulshan.spring_boot_microservice.pojo.Person;
import com.gulshan.spring_boot_microservice.service.PersonService;

@Component
public class PersonComponent {
    @Autowired
    PersonService personService;

    public Person getPerson(String firstName, String lastName, Optional<String> age) throws SystemException {
        Integer personAge = personService.getAge(age);
        return personService.getService(personAge, firstName, lastName);

    }

}
