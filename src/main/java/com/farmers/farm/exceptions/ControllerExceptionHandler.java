package com.farmers.farm.exceptions;

import com.farmers.farm.dtos.BasicResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(AnimalNotFoundException.class)
  public ResponseEntity<BasicResponseDTO<String>> handleNotFoundException(AnimalNotFoundException e) {
    return new ResponseEntity<>(
        new BasicResponseDTO<>(
            "There was a problem searching for that animal",
            HttpStatus.NOT_FOUND.getReasonPhrase(),
            e.getLocalizedMessage()
        ),
        HttpStatus.NOT_FOUND
    );
  }
}
