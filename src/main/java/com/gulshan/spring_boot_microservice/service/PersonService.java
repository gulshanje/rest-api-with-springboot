package com.gulshan.spring_boot_microservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gulshan.spring_boot_microservice.exception.SystemException;
import com.gulshan.spring_boot_microservice.pojo.Person;

@Service
public class PersonService {
    public Person getService(Integer age, String firstName, String lastName) throws SystemException {
        if (age != null) {
            return new Person(firstName, lastName, age);
        }
        return new Person(firstName, lastName);
    }

    public Integer getAge(Optional<String> age) throws SystemException {
        if (age.isPresent()) {
            try {
                return Integer.parseInt(age.get());
            } catch (Exception e) {
                throw new SystemException("103", "Age is not a integer");
            }

        }
        return null;
    }
}
