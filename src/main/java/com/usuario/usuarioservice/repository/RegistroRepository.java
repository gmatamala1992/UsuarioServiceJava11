package com.usuario.usuarioservice.repository;
import com.usuario.usuarioservice.entity.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro, Long> {

}