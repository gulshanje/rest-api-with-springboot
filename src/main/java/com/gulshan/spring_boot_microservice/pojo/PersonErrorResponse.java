package com.gulshan.spring_boot_microservice.pojo;

import com.gulshan.spring_boot_microservice.exception.PersonError;

public class PersonErrorResponse {

    private Person person;
    private PersonError PersonError;
    public PersonErrorResponse(Person person, PersonError personError) {
        this.person = person;
        PersonError = personError;
    }
    public Person getPerson() {
        return person;
    }
    public PersonError getPersonError() {
        return PersonError;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public void setPersonError(PersonError personError) {
        PersonError = personError;
    }

    
}
