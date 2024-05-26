package com.gulshan.spring_boot_microservice.exception;

public class PersonError {
    public String errorId;
    public String errorMessage;
    
    public PersonError() {}
    public PersonError(String errorId, String errorMessage) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
    }
    
}
