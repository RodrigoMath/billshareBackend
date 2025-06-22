package com.billshare.backend.application.useCases;

import java.util.HashMap;

public interface EmailUseCase {

    public String enviarEmailComCodigoDeCheckin(String destinario, String assunto, String mensagem);

    public void enviarEmailComRelatorioMensal(HashMap<String, Long> relatorioPorUsuário);
}
