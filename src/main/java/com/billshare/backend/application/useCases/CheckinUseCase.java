package com.billshare.backend.application.useCases;

import java.time.LocalDate;
import java.util.HashMap;

public interface CheckinUseCase {

    public HashMap<String, Long> contagemMensalPorUsuario(LocalDate mesReferencia);
}
