package com.usuario.usuarioservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private Date created;
    private Date lastLogin;
    private String token;
    private boolean isActive;
}
