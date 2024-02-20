package com.example.hw8task1.events;

import com.example.hw8task1.domain.Note;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Событие создания новой заметки
 */
@Getter
public class NoteCreatedEvent extends ApplicationEvent {
    /**
     * новая заметка
     */
    private Note note;

    public NoteCreatedEvent(Object source, Note note) {
        super(source);
        this.note = note;
    }
}
