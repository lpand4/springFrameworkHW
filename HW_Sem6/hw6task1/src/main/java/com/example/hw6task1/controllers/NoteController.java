package com.example.hw6task1.controllers;

import com.example.hw6task1.domain.Note;
import com.example.hw6task1.exceptions.NoteNotFoundException;
import com.example.hw6task1.repository.NoteRepository;
import com.example.hw6task1.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService service;


    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<>(service.createNote(note), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNote(){
        return new ResponseEntity<>(service.getAllNote(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable Long id){
        Optional<Note> note = service.getNoteById(id);
        if (note.isEmpty()){
            return ResponseEntity.badRequest().body(new NoteNotFoundException("Заметки с данным айди не существует"));
        }
        return new ResponseEntity<>(note.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@RequestBody Note note,@PathVariable   Long id){
        return new ResponseEntity<>(service.updateNote(note,id), HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteNote(Long id){
        service.deleteNote(id);
        return ResponseEntity.ok().build();
    }

}
