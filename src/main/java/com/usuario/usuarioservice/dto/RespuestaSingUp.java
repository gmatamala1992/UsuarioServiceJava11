package com.usuario.usuarioservice.dto;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespuestaSingUp {
    private UUID id;
    private Date created;
    private Date lastLogin;
    private String token;
    private boolean isActive;

}
