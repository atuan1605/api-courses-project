package com.example.coursesample.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErrorMessage {
    private HttpStatus httpStatus;
    private String message;
}
