package com.example.hw6task1.service;

import com.example.hw6task1.domain.Note;
import com.example.hw6task1.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository repository;

    public Note createNote(Note note){
        return repository.save(note);
    }

    public List<Note> getAllNote(){
        return repository.findAll();
    }

    public Optional<Note> getNoteById(Long id){
        return repository.findById(id);
    }

    public Note updateNote(Note note, Long id){
        note.setId(id);
        return repository.save(note);
    }

    public void deleteNote(Long id){
        repository.deleteById(id);
    }
}
