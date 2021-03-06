package com.openclassrooms.mediscreen_patient.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Log4j2
public class IdPatientException extends RuntimeException {
    public IdPatientException(String message) {
        super(message);
        log.info(message);
    }
}
