package com.gulshan.spring_boot_microservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gulshan.spring_boot_microservice.pojo.Person;

@Service
public class PersonService {
    public Person getService(Integer age, String firstName, String lastName) {
        if (age != null) {
            return new Person(firstName, lastName, age);
        }
        return new Person(firstName, lastName);
    }

    public Integer getAge(Optional<String> age) {
        if (age.isPresent()) {
            try {
                return Integer.parseInt(age.get());
            } catch (Exception e) {
                return null;
            }

        }
        return null;
    }
}
