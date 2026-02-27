package com.usuario.usuarioservice.dto;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PhonesDto {
        private long    number;
        private int     citycode;
        private String  countrycode;
}
