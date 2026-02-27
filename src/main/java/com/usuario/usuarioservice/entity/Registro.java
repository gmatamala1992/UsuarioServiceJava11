package com.usuario.usuarioservice.entity;
import javax.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Registro {
    @Id
    private UUID id;
    private Date created;
    private Date lastLogin;
    @Column(length = 1024)
    private String token;
    private boolean isActive;

}
