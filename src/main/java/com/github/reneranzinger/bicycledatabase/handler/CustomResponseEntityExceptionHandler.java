package com.github.reneranzinger.bicycledatabase.handler;

import javax.persistence.EntityNotFoundException;

import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
    private static final Logger logger = LoggerFactory
            .getLogger(CustomResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = { ObjectNotFoundException.class, EntityNotFoundException.class })
    public ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request)
    {
        logger.info("CustomResponseEntityExceptionHandler::handleCustomException");
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.NOT_FOUND;

        logger.error("Handling Error: {}", ex.getMessage());
        return this.handleExceptionInternal(ex, null, headers, status, request);
    }
}
