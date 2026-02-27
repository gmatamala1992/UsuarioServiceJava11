package com.usuario.usuarioservice.controller;
import com.usuario.usuarioservice.dto.ErrorResponse;
import com.usuario.usuarioservice.exception.UsuarioException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponse>> manejarErroresValidacion(MethodArgumentNotValidException ex) {
        List<ErrorResponse> errores = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ErrorResponse(
                        error.getField(),
                        error.getDefaultMessage()
                ))
                .collect(Collectors.toList());

        // 3. Devolvemos la lista. Spring NO agregará campos extras
        // porque el tipo de retorno es List<ErrorCampoDetalle>.
        return ResponseEntity.badRequest().body(errores);
    }


}
