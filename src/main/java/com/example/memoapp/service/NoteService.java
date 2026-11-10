package com.example.memoapp.service;

import com.example.memoapp.dto.Note;
import com.example.memoapp.exception.NoteArgumentNotValidException;
import com.example.memoapp.exception.NoteNotFoundException;
import com.example.memoapp.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note save(Note note){
//        titleが空の場合のバリデーション
        if (note.getTitle() == null || note.getTitle().isEmpty()){
            throw new NoteArgumentNotValidException("title is empty");
        }
        if (note.getContent() == null || note.getContent().isEmpty()){
            throw new NoteArgumentNotValidException("content is empty");
        }

        noteRepository.insertNote(note);
        return note;
    }

    public Note findById(long id){
        Note note =  noteRepository.findById(id);

        if (note == null){
            throw new NoteNotFoundException(id);
        }
        return note;
    }

    public boolean delete(long id){
        if(!noteRepository.delete(id)){
            throw new NoteNotFoundException(id);
        }
        return true;
    }

    @Transactional
    public Note update(Note note, long id){
        if (note.getTitle() == null || note.getTitle().isEmpty()){
            throw new NoteArgumentNotValidException("title is empty");
        }
        if (note.getContent() == null || note.getContent().isEmpty()){
            throw new NoteArgumentNotValidException("content is empty");
        }
//        指定されたIDが存在しない場合のバリデーション
        Note targetNote = noteRepository.findById(id);
        if (targetNote == null){
            throw new NoteNotFoundException(id);
        }
        note.setId(id);
        noteRepository.update(note);
        return note;
    }
}
