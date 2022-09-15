package com.rtech.gerenciamentoFresadora.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@ControllerAdvice(basePackages = "com.rtech.gerenciamentoFresadora.controllers.ClientController")
public class ClientControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> clientNotFound(ClientNotFoundException clientNotFound){
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(), "Client not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageExceptionHandler> argumentsNotValid(MethodArgumentNotValidException notValid) {

        BindingResult result = notValid.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        StringBuilder sb = new StringBuilder("The following fields cannot be null: ");
        for (FieldError fieldError : fieldErrors) {
            sb.append(" | ");
            sb.append(" -> ");
            sb.append(fieldError.getField());
            sb.append(" <- ");

        }

        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.BAD_REQUEST.value(), sb.toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
