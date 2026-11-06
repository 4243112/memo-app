package com.example.memoapp.exception.handler;

import com.example.memoapp.exception.NoteArgumentNotValidException;
import com.example.memoapp.exception.NoteNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<String> handleNoteNotFoundException(NoteNotFoundException e){
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> NoteArgumentNotValidException(NoteArgumentNotValidException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
