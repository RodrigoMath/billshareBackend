package com.billshare.backend.adapters.inbound.controller.usuarioContext;

import com.billshare.backend.adapters.inbound.UsuarioDTO;
import com.billshare.backend.adapters.outbound.entities.JpaUsuario;
import com.billshare.backend.adapters.outbound.repositories.JpaUsuarioRepository;
import com.billshare.backend.application.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JpaUsuarioRepository jpaUsuarioRepository;

    @PostMapping("/usuarios")
    public void registerUser(@RequestBody UsuarioDTO usuarioDTO){
        try {
            usuarioService.validaUsuario(usuarioDTO);
            //salvar o usuario

        }catch(Exception e){

        }
    }

}
