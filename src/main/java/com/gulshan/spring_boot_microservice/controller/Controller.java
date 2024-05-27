package com.gulshan.spring_boot_microservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gulshan.spring_boot_microservice.component.PersonComponent;
import com.gulshan.spring_boot_microservice.exception.PersonError;
import com.gulshan.spring_boot_microservice.exception.SystemException;
import com.gulshan.spring_boot_microservice.pojo.Person;
import com.gulshan.spring_boot_microservice.pojo.PersonErrorResponse;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Controller {

    private static final Log LOGGING = LogFactory.getLog(Person.class);
    @Autowired
    PersonComponent personComponent;

    // http://localhost:9090/greet
    @GetMapping("/greet")
    public String getGreet() {
        return "Greeting";
    }

    //
    @GetMapping("/person/fn/{firstName}/ln/{lastName}")
    public ResponseEntity<PersonErrorResponse> getDetails(
            @RequestHeader(value = "clientId", required = true) String clientId,
            @PathVariable(value = "firstName") String firstName,
            @PathVariable(value = "lastName") String lastName,
            @RequestParam Optional<String> age) {

        Person person = null;
        LOGGING.info("Logging Info");
        try {
            person = personComponent.getPerson(firstName, lastName, age);
        } catch (SystemException e) {
            LOGGING.error("Service error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new PersonErrorResponse(null, new PersonError(e.errorId, e.errorMessage)));
        }

        if (!clientId.equalsIgnoreCase("mursu")) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new PersonErrorResponse(null, new PersonError("101", "Wrong Header")));
        }
        if (person != null) {

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new PersonErrorResponse(person, null));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new PersonErrorResponse(null, new PersonError("101", "Person is null")));
        }

    }

    @PostMapping(value = "/addperson")
    public ResponseEntity<Person> createPerson(
            @RequestBody Person person) {
        return ResponseEntity.ok().body(person);

    }

    @DeleteMapping(value = "/deleteperson")
    public ResponseEntity<Person> deletePerson(
            @RequestBody Person person) {
        return ResponseEntity.ok().body(person);

    }

    @PutMapping(value = "/updateperson")
    public ResponseEntity<Person> updatePerson(
            @RequestBody Person person) {
        return ResponseEntity.ok().body(person);

    }

}
