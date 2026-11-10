package com.example.memoapp.repository;

import com.example.memoapp.dto.Note;
import com.example.memoapp.exception.NoteNotFoundException;
import com.example.memoapp.Mapper.NoteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteRepository {
    private final NoteMapper noteMapper;

    public NoteRepository(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }
    public List<Note> findALl() {
        return noteMapper.findAll();
    }
    public int insertNote(Note note) {
        return noteMapper.insert(note);
    }
    public Note findById(long id) {
        return noteMapper.findById(id);
    }
    public boolean delete(long id) {
        return noteMapper.delete(id) == 1;
    }
    public Note update(Note note) {
        if (noteMapper.update(note) == 0) {
            throw new NoteNotFoundException(note.getId());
        }
        return note;
    }
}