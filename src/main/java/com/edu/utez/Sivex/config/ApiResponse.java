package com.edu.utez.Sivex.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private Object data;
    private HttpStatus status;
    private boolean error;
    private String Mensaje;

    public ApiResponse(Object data, HttpStatus status, String Mensaje) {
        this.data = data;
        this.status = status;
        this.Mensaje=Mensaje;
    }

    public ApiResponse(Object data, boolean error, String mensaje) {
        this.data = data;
        this.error = error;
        Mensaje = mensaje;
    }
}
