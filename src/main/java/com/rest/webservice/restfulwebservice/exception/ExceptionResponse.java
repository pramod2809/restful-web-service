package com.rest.webservice.restfulwebservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class ExceptionResponse {
    private Date date;
    private String message;
    private String details;


    public ExceptionResponse(Date date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }

    public Date getDate() {
        return date;
    }



    public String getMessage() {
        return message;
    }


    public String getDetails() {
        return details;
    }



    @Override
    public String toString() {
        return "ExceptionResponse{" +
            "date=" + date +
            ", message='" + message + '\'' +
            ", details='" + details + '\'' +
            '}';
    }
}
