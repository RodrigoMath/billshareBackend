package com.billshare.backend.application.services.utils;

import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class MensagemService {
    public static String gerarMensagemDeCheckin(HashMap<String, Long> dadosCheckin) {
        StringBuilder mensagem = new StringBuilder();
        for (String chave : dadosCheckin.keySet()) {
            mensagem.append("Usuário: ").append(chave)
                    .append(" realizou ").append(dadosCheckin.get(chave))
                    .append(" check-in.\n");
        }
        return mensagem.toString();
    }

}
