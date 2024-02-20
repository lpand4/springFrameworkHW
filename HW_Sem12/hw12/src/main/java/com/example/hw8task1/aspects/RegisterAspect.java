package com.example.hw8task1.aspects;

import com.example.hw8task1.events.NoteCreatedEvent;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Аспект регистрации действий пользователя
 */
@Component
@Aspect
public class RegisterAspect implements ApplicationListener<NoteCreatedEvent> {


    /**
     * Регистрация использования метода с датой и временем выполнения
     * @param joinPoint
     * @return
     */
    @SneakyThrows
    @Around(value = "@annotation(com.example.hw8task1.aspects.annotation.TrackUserAction)")
    public Object registerUserAction(ProceedingJoinPoint joinPoint) {
        Object result = joinPoint.proceed();
        long start = System.currentTimeMillis();
        long executionTime = System.currentTimeMillis() - start;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println("\033[33m" + formatter.format(date) +
                ": " + "Пользователь использовал метод " +
                joinPoint.getSignature().getName() +
                ". Метод был выполнен за " + executionTime + "мс. \033[0m");
        return result;
    }

    /**
     * Слушает была ли создана новая заметка и при ее создании оповещает нас в консоли
     * @param event Событие создания новой заметки
     */
    @Override
    public void onApplicationEvent(NoteCreatedEvent event) {
        System.out.println("\u001B[31m▄▄▄▄▄▄▄▄▄▄NOTE WAS CREATED▄▄▄▄▄▄▄▄▄▄\u001B[0m");
        System.out.println(event.getNote());
        System.out.println("\u001B[31m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\u001B[0m");
    }
}
