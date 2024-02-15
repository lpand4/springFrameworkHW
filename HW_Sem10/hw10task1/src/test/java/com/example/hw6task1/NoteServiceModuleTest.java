package com.example.hw6task1;

import com.example.hw6task1.domain.*;
import com.example.hw6task1.repository.NoteRepository;
import com.example.hw6task1.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NoteServiceModuleTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteService noteService;

    @Test
    public void createNoteTest(){
        //Arrange
        Note note = new Note();
        note.setId(1L);
        note.setHeader("Сделать домашнее задание");
        note.setDescription("По аналогии с примерами показанными на семинаре," +
                " добавить модульное тестирование и интеграционное для одного" +
                " из своих проектов(так же протестировать один из методов сервиса).");
        note.setDateOfCreation(LocalDateTime.now());

        //Act
        noteService.createNote(note);

        //Assert
        verify(noteRepository).save(note);

    }
    @Test
    public void updateNoteTest(){
        //Arrange
        Note note = new Note();
        note.setId(1L);
        note.setHeader("Сделать домашнее задание");
        note.setDescription("По аналогии с примерами показанными на семинаре," +
                " добавить модульное тестирование и интеграционное для одного" +
                " из своих проектов(так же протестировать один из методов сервиса).");
        note.setDateOfCreation(LocalDateTime.now());

        noteService.createNote(note);

        Note updatedNote = new Note();
        updatedNote.setId(1L);
        updatedNote.setHeader("Выпить кофе");
        updatedNote.setDescription("Кофе молотый - 1 ч. ложка с горкой\n" +
                "Молоко - 80 мл\n" +
                "Вода - 50 мл\n" +
                "Имбирь молотый - 1/3 ч. ложка\n" +
                "Сахар - 1 ч. ложка (или по вкусу)");
        updatedNote.setDateOfCreation(LocalDateTime.now());
        //Act
        noteService.updateNote(updatedNote, 1L);
        //Assert
        verify(noteRepository).save(updatedNote);
    }


}
