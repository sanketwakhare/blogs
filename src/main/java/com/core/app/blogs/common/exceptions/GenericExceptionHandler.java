package com.core.app.blogs.common.exceptions;

import com.core.app.blogs.common.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exc) {
        ErrorDTO errorDTO = new ErrorDTO(exc.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler({ModelNotFoundException.class, InvalidModelException.class})
    public ResponseEntity<ErrorDTO> handleModelsException(ModelNotFoundException exc) {
        ErrorDTO errorDTO = new ErrorDTO(exc.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleRuntimeException(RuntimeException exc) {
        ErrorDTO errorDTO = new ErrorDTO(exc.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
    }
}
