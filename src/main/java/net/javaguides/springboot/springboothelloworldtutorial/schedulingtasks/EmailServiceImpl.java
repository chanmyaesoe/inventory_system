package net.javaguides.springboot.springboothelloworldtutorial.schedulingtasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
    @Autowired
    private JavaMailSender emailSender;

//    @EventListener(ApplicationReadyEvent.class)
    public void sendSimpleMessage() {

    }
}
