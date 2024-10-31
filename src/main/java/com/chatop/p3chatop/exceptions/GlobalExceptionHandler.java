package com.chatop.p3chatop.exceptions;

import com.chatop.p3chatop.dto.ErrorResponseDTO;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error); // 400
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setMessage("Validation error");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error); //400
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponseDTO> handleBadCredentialsException(BadCredentialsException exception) {
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setMessage("Invalid credentials");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error); // 401
    }

    @ExceptionHandler(AccountStatusException.class)
    public ResponseEntity<ErrorResponseDTO> handleAccountStatusException(AccountStatusException exception) {
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setMessage("The account is locked");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error); // 403
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponseDTO> handleAccessDeniedException(AccessDeniedException exception) {
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setMessage("You are not authorized to access this resource");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error); // 403
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ErrorResponseDTO> handleSignatureException(SignatureException exception) {
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setMessage("The JWT signature is invalid");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error); // 403
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorResponseDTO> handleExpiredJwtException(ExpiredJwtException exception) {
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setMessage("The JWT token has expired");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error); // 403
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneralException(Exception exception) {
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setMessage("Unknown internal server error.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error); // 500
    }
}