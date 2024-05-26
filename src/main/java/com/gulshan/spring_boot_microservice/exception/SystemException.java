package com.gulshan.spring_boot_microservice.exception;

public class SystemException extends RuntimeException {

    public String errorId;
    public String errorMessage;

    public SystemException(String errorId, String errorMessage) {
        super();
        this.errorId = errorId;
        this.errorMessage = errorMessage;
    }

    
    public static final long serialVersionUid = 1L;

    public String getErrorId() {
        return errorId;
    }


    public String getErrorMessage() {
        return errorMessage;
    }


    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }


    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    
    
}
