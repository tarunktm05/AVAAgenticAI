package com.example.gitlab.exception;

import com.example.gitlab.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateMilestoneTitleException.class)
    public ResponseEntity<ErrorResponseDTO> handleDuplicateMilestoneTitle(DuplicateMilestoneTitleException ex) {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(ex.getMessage()));
    }

    @ExceptionHandler(InvalidDateRangeException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidDateRange(InvalidDateRangeException ex) {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(ex.getMessage()));
    }

    @ExceptionHandler(ReleaseTagNotUniqueException.class)
    public ResponseEntity<ErrorResponseDTO> handleReleaseTagNotUnique(ReleaseTagNotUniqueException ex) {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(ex.getMessage()));
    }

    @ExceptionHandler(ReleaseAlreadyAssociatedException.class)
    public ResponseEntity<ErrorResponseDTO> handleReleaseAlreadyAssociated(ReleaseAlreadyAssociatedException ex) {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(ex.getMessage()));
    }

    @ExceptionHandler(MilestoneNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleMilestoneNotFound(MilestoneNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDTO(ex.getMessage()));
    }

    @ExceptionHandler(ReleaseNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleReleaseNotFound(ReleaseNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDTO(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationException(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .findFirst()
                .orElse("Validation error");
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(msg));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponseDTO("Internal server error"));
    }
}