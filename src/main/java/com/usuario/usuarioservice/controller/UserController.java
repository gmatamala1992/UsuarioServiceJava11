package com.usuario.usuarioservice.controller;

import com.usuario.usuarioservice.dto.CreateUserRequest;
import com.usuario.usuarioservice.dto.LoginDto;
import com.usuario.usuarioservice.dto.RespuestaSingUp;
import com.usuario.usuarioservice.entity.Usuario;
import com.usuario.usuarioservice.exception.UsuarioException;
import com.usuario.usuarioservice.security.JwtUtil;
import com.usuario.usuarioservice.services.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UsuarioService usuarioService;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping(path = "consultar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsers();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping(path = "sign-up", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaSingUp> createUser(@Valid @RequestBody CreateUserRequest request) {
        Usuario usuario = new Usuario();
        RespuestaSingUp respuestas = new RespuestaSingUp();
        Usuario existUser           =   usuarioService.getUserByEmail(request.getEmail());
        String passwordEncriptada   =   passwordEncoder.encode(request.getPassword());
        if (existUser != null) {
          throw new UsuarioException();
        }else{
            try {
                String token    = jwtUtil.generateToken(request.getEmail());
                Date created    = new Date();
                Date lastLogin  = new Date();
                usuario.setEmail(request.getEmail());
                usuario.setPassword(passwordEncriptada);
                usuario.setName(request.getName());
                usuario.setPhones(request.getPhones().toString());
                usuario.setCreated(created);
                usuario.setLastLogin(lastLogin);
                usuario.setActive(true);
                usuario.setToken(token);
                usuarioService.crearUsuario(usuario);
                respuestas = usuarioService.getLastUser();
            } catch (Exception e) {
                System.out.println("Error al guardar el registro: " + e.getMessage());
            }
        }
        return ResponseEntity.ok(respuestas);
    }

    @PostMapping(path = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> loginUser(@RequestBody LoginDto request) {
        Usuario existUser           =  usuarioService.getUserByEmail(request.getCorreo());
        //if (existUser != null && passwordEncoder.matches(request.getPassword(), existUser.getPassword())) {
        if(existUser != null){
            return ResponseEntity.ok(existUser);
        } else {
            return ResponseEntity.status(401).build();
        }
    }




}
