package com.billshare.backend.adapters.inbound.controller.usuarioContext;

import com.billshare.backend.adapters.inbound.UsuarioDTO;
import com.billshare.backend.application.useCases.EmailUseCase;
import com.billshare.backend.application.useCases.UsuarioUseCase;
import com.billshare.backend.domain.userContext.UserRepository;
import com.billshare.backend.domain.userContext.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    UsuarioUseCase usuarioUseCase;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/usuario")
    public ResponseEntity<String> registerUser(@RequestBody UsuarioDTO usuarioDTO){
        try {
            usuarioUseCase.validaUsuario(usuarioDTO);
            Usuario usuario = new Usuario(usuarioDTO.getName(), usuarioDTO.getEmail());
            usuario = userRepository.save(usuario);
            usuarioUseCase.enviarCodigoAoUsuario(usuario);

            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
