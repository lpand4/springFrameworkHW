package com.example.hw8task1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;
import java.time.LocalDateTime;

@Configuration
public class IntegrationConfiguration {


    /**
     * Входной текст
     * @return
     */
    @Bean
    public MessageChannel textInputChannel() {
        return new DirectChannel();
    }

    /**
     * Текст записи в файл
     * @return
     */
    @Bean
    public MessageChannel fileWriterChannel(){
        return new DirectChannel();
    }

    /**
     * Подготовка входного текста для записи в файл
     * @return
     */
    @Bean
    @Transformer(inputChannel = "textInputChannel", outputChannel = "fileWriterChannel")
    public GenericTransformer<String, String> dataTransformer(){
        return text -> {
            return "[" + LocalDateTime.now() + "] | " + text;
        };
    }

    /**
     * Запись текста в файл, настройка параметров записи
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler writingMessageHandler(){
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File("./user-requests"));
        handler.setAppendNewLine(true);
        handler.setAutoCreateDirectory(true);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setExpectReply(false);

        return handler;
    }

}
