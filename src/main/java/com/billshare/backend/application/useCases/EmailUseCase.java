package com.billshare.backend.application.useCases;

public interface EmailUseCase {

    public String enviarMensagemDeEmail(String destinario, String assunto, String mensagem);
}
