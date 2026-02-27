// Archivo: java/com/usuario/usuarioservice/services/Impl/UsuarioServiceImplTest.java
package com.usuario.usuarioservice.services.Impl;

import com.usuario.usuarioservice.dto.RespuestaSingUp;
import com.usuario.usuarioservice.entity.Usuario;
import com.usuario.usuarioservice.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    public UsuarioServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);

        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> resultado = usuarioService.getAllUsers();

        assertEquals(2, resultado.size());
        assertEquals(usuarios, resultado);
    }

    @Test
    void testGetLastUser(){
        RespuestaSingUp respuesta = new RespuestaSingUp();
        when(usuarioRepository.findTopByOrderByCreatedDesc()).thenReturn(respuesta);

        RespuestaSingUp lastUser = usuarioService.getLastUser();
        assertEquals(respuesta, lastUser);
    }

    @Test
    void testGetUserByEmail(){
        Usuario usuario1 = new Usuario();
        String email = "gabo@gmail.com";
        when(usuarioRepository.findByEmail(email)).thenReturn(usuario1);
        Usuario userMail = usuarioService.getUserByEmail(email);
        assertEquals(usuario1, userMail);
    }

    @Test
    void testCreateUser(){
        Usuario user = new Usuario();
        when(usuarioRepository.save(user)).thenReturn(user);
        Usuario userRes = usuarioService.crearUsuario(user);
        assertEquals(user, userRes);
    }




}
