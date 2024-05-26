package com.gulshan.spring_boot_microservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.gulshan.spring_boot_microservice.component.PersonComponent;
import com.gulshan.spring_boot_microservice.pojo.Person;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Controller {
    @Autowired
    PersonComponent personComponent;

    // http://localhost:9090/greet
    @GetMapping("/greet")
    public String getGreet() {
        return "Greeting";
    }

    //
    @GetMapping("/printMessage/fn/{firstName}/ln/{lastName}")
    public ResponseEntity<Person> printMessage(
            @RequestHeader(value = "clientId", required = true) String clientId,
            @PathVariable(value = "firstName") String firstName,
            @PathVariable(value = "lastName") String lastName,
            @RequestParam Optional<String> age) {

        Person person = personComponent.getPerson(firstName, lastName, age);
        if (clientId.equalsIgnoreCase("mursu")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        if (person != null) {
            return ResponseEntity.status(HttpStatus.OK).body(person);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

}
