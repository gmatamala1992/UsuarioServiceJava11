package com.usuario.usuarioservice.repository;

import com.usuario.usuarioservice.dto.RespuestaSingUp;
import com.usuario.usuarioservice.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

    @Query("SELECT new com.usuario.usuarioservice.dto.RespuestaSingUp(u.id,u.created,u.lastLogin,u.token,u.isActive) FROM Usuario u")
    RespuestaSingUp findAllResumen();

    @Query("SELECT new com.usuario.usuarioservice.dto.RespuestaSingUp(u.id,u.created,u.lastLogin,u.token,u.isActive) FROM Usuario u WHERE u.created = (SELECT MAX(u2.created) FROM Usuario u2)")
    RespuestaSingUp findTopByOrderByCreatedDesc();
}
