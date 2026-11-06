package com.example.memoapp.exception;

public class NoteNotFoundException  extends RuntimeException{
    public NoteNotFoundException(Long id){
        super("指定されたIDのノートが見つかりません: " + id );
    }
}
