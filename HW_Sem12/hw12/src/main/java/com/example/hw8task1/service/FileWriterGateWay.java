package com.example.hw8task1.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInputChannel")
public interface FileWriterGateWay {
    void writeDataToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}
