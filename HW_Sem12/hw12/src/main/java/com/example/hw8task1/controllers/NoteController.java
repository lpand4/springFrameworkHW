package com.example.hw8task1.controllers;

import com.example.hw8task1.domain.Note;
import com.example.hw8task1.exceptions.NoteNotFoundException;
import com.example.hw8task1.service.FileWriterGateWay;
import com.example.hw8task1.service.NoteService;
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

    private final FileWriterGateWay fileWriterGateWay;
    private final NoteService service;

    /**
     * Создание заметки и запись в базу
     *
     * @param note заметка
     * @return заметка
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        fileWriterGateWay.writeDataToFile(Thread.currentThread().getStackTrace()[1].getMethodName() + ".txt",  note.toString());
        return new ResponseEntity<>(service.createNote(note), HttpStatus.CREATED);
    }

    /**
     * Получение списка заметок
     *
     * @return список заметок
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNote() {
        List<Note> resultList = service.getAllNote();
        fileWriterGateWay.writeDataToFile(Thread.currentThread().getStackTrace()[1].getMethodName() + ".txt",  resultList.toString());
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    /**
     * Получение записки по айди
     *
     * @param id айди записки
     * @return записка, если нет записки с таким айди, то ошибка
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable Long id) {
        Optional<Note> note = service.getNoteById(id);
        if (note.isEmpty()) {
            fileWriterGateWay.writeDataToFile(Thread.currentThread().getStackTrace()[1].getMethodName() + ".txt",  new NoteNotFoundException("Заметки с данным айди не существует").toString());
            return ResponseEntity.badRequest().body(new NoteNotFoundException("Заметки с данным айди не существует"));
        }
        fileWriterGateWay.writeDataToFile(Thread.currentThread().getStackTrace()[1].getMethodName() + ".txt",  note.toString());
        return new ResponseEntity<>(note.get(), HttpStatus.OK);
    }

    /**
     * Обновление записки по айди
     *
     * @param note новые данные записки
     * @param id   айди необходимой запиаски
     * @return измененная записка
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@RequestBody Note note, @PathVariable Long id) {
        fileWriterGateWay.writeDataToFile(Thread.currentThread().getStackTrace()[1].getMethodName() + ".txt",  note.toString());
        return new ResponseEntity<>(service.updateNote(note, id), HttpStatus.OK);
    }

    /**
     * Удаление записки по айди
     *
     * @param id нужное айди
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        service.deleteNote(id);
        fileWriterGateWay.writeDataToFile(Thread.currentThread().getStackTrace()[1].getMethodName() + ".txt",  id.toString());
        return ResponseEntity.ok().build();
    }
}
