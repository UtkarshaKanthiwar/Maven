package com.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiExceptionResponse {

	private final String message;
	private final HttpStatus status;
	private final LocalDateTime exceptionTimeStamp;

}
