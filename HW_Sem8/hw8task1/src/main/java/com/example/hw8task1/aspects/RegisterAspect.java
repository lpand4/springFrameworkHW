package com.example.hw8task1.aspects;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class RegisterAspect {

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

}
