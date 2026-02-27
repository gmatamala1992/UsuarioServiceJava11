package com.usuario.usuarioservice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.*;
import java.util.ArrayList;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    private String name;

    @NotBlank(message = "El email es obligatorio")
    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Por favor, introduce un formato de email válido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8,max = 12, message = "La contraseña debe tener un largo minimo de 8 y maximo de 12")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{10,}$",
            message = "La contraseña debe tener: una mayúscula, una minúscula, un número, un carácter especial y sin espacios."
    )
    private String password;
    private ArrayList<PhonesDto> phones;
}



