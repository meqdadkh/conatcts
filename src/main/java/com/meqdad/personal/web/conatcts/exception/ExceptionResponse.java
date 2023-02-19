package com.meqdad.personal.web.conatcts.exception;

import java.time.Instant;

public class ExceptionResponse {
    private Instant Date;
    private String message;
    private String Details;

    public ExceptionResponse(Instant date, String message, String details) {
        Date = date;
        this.message = message;
        Details = details;
    }

    public Instant getDate() {
        return Date;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return Details;
    }
}
