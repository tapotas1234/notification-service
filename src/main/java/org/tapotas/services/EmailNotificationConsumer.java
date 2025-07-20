package org.tapotas.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.tapotas.model.EmailNotificationMessage;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class EmailNotificationConsumer {

    private final EmailSender emailSender;
    private final Logger logger = LoggerFactory.getLogger(EmailNotificationConsumer.class);

     @KafkaListener(topics = "${kafka.topic.email-notifications}")
     void listen(EmailNotificationMessage message) {
        try {
            logger.info("Получили сообщение из кафки на email: {}", message.email());
            emailSender.sendEmail(message.email(), message.subject(), message.content());
        } catch (Exception e) {
            logger.error("Ошибка при получении сообщения: {}", e.getMessage());
        }
     }
}
