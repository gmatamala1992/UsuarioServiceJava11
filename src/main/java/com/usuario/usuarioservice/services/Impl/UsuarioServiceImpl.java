package com.usuario.usuarioservice.services.Impl;

import com.usuario.usuarioservice.dto.RespuestaSingUp;
import com.usuario.usuarioservice.entity.Usuario;
import com.usuario.usuarioservice.repository.UsuarioRepository;
import com.usuario.usuarioservice.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public RespuestaSingUp getLastUser() {
        return usuarioRepository.findTopByOrderByCreatedDesc();
    }

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Usuario getUserByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }




}
