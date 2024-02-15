package com.example.hw6task1.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(String message) {
        super(message);
    }
}
