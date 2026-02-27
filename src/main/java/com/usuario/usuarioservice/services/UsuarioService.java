package com.usuario.usuarioservice.services;

import com.usuario.usuarioservice.dto.RespuestaSingUp;
import com.usuario.usuarioservice.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);

    RespuestaSingUp getLastUser();

    List<Usuario> getAllUsers();

    Usuario getUserByEmail(String email);

}
