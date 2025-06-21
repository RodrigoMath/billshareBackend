package com.billshare.backend.application.services;

import com.billshare.backend.application.useCases.EmailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailUseCase {

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    String remetente;

    @Override
    public String enviarMensagemDeEmail(String destinario, String assunto, String mensagem) {
        try{
            SimpleMailMessage email = new SimpleMailMessage();
            email.setFrom(remetente);
            email.setTo(destinario);
            email.setSubject(assunto);
            email.setText(mensagem);
            javaMailSender.send(email);
            return "e-mail enviado com sucesso para " + destinario;
        }catch (Exception e) {
            throw new RuntimeException("Erro ao enviar e-mail: " + e.getMessage());
        }
    }
}
