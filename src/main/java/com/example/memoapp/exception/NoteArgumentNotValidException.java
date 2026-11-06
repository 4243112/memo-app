package com.example.memoapp.exception;

public class NoteArgumentNotValidException extends RuntimeException {
    public NoteArgumentNotValidException(String message) {

        super(message);
    }
}
