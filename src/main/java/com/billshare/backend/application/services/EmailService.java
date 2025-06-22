package com.billshare.backend.application.services;

import com.billshare.backend.application.services.utils.MensagemService;
import com.billshare.backend.application.useCases.EmailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class EmailService implements EmailUseCase {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    MensagemService mensagemService;

    @Value("${spring.mail.username}")
    String remetente;

    @Override
    public String enviarEmailComCodigoDeCheckin(String destinario, String assunto, String mensagem) {
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

    @Override
    public void enviarEmailComRelatorioMensal(HashMap<String, Long> usuarioECheckins) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(remetente);
        email.setTo("rodrigormathias@hotmail.com");
        email.setSubject("Relatório Mensal de Check-ins");
        email.setText(mensagemService.gerarMensagemDeCheckin(usuarioECheckins));
        javaMailSender.send(email);
    }
}
