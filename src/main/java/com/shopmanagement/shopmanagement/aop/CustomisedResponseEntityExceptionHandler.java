package com.shopmanagement.shopmanagement.aop;

import com.shopmanagement.shopmanagement.dto.ResponseDto;
import com.shopmanagement.shopmanagement.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDto> handleAnyException(ResourceNotFoundException ex, WebRequest request) {
        ResponseDto responseDto = new ResponseDto(false, ex.getLocalizedMessage());
        return new ResponseEntity<>(responseDto, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
