package com.chatop.p3chatop.exceptions;

import com.chatop.p3chatop.dto.ErrorResponseDTO;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleSecurityException(Exception exception) {
        ErrorResponseDTO error = new ErrorResponseDTO();

        if (exception instanceof BadCredentialsException) { // 401
            error.setMessage("error");
        }

        if (exception instanceof AccountStatusException) { // 403
            error.setMessage("The account is locked");
        }

        if (exception instanceof AccessDeniedException) { // 403
            error.setMessage("You are not authorized to access this resource");
        }

        if (exception instanceof SignatureException) { // 403
            error.setMessage("The JWT signature is invalid");
        }

        if (exception instanceof ExpiredJwtException) { // 403
            error.setMessage("The JWT token has expired");
        }

        if (error.getMessage() == null) { // 500
            error.setMessage("Unknown internal server error.");
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }
}