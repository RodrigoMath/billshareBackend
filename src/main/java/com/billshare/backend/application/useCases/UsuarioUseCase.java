package com.billshare.backend.application.useCases;

import com.billshare.backend.adapters.inbound.UsuarioDTO;
import com.billshare.backend.domain.userContext.Usuario;

public interface UsuarioUseCase {
    public void checaSeUsuarioExiste(Long idUsuario);

    public void validaUsuario(UsuarioDTO usuario);

    public boolean isEmailValido(String email);

    public String enviarCodigoAoUsuario(Usuario usuario);
}
