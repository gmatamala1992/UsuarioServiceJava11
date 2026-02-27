package com.usuario.usuarioservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String campo;
    private String mensaje;
}
