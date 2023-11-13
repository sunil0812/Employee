package com.example.Employee.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailserviceIMPL implements EmailService{


    @Autowired
    private JavaMailSender sender;

    @Override
    public void EmailSend(String to, String sub, String text) {
        SimpleMailMessage congtext = new SimpleMailMessage();
        congtext.setTo(to);
        congtext.setSubject(sub);
        congtext.setText(text);
        sender.send(congtext);

    }
}
