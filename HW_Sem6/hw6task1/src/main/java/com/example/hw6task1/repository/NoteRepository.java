package com.example.hw6task1.repository;

import com.example.hw6task1.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    /**
     * Поиск заметки по айди
     * @param id нужное айди
     * @return заметка
     */
    Optional<Note> findById(Long id);
}
