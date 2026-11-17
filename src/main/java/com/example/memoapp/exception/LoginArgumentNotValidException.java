package com.example.memoapp.exception;

public class LoginArgumentNotValidException extends RuntimeException {
  public LoginArgumentNotValidException(String message) {
    super(message);
  }
}