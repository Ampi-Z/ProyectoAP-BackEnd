
package com.portfolio.amz.Security.Dto;

import jakarta.validation.constraints.NotBlank;

public class LoginUsuario {

    @NotBlank
    private String nombreUsuario ;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @NotBlank
    private String password ;

}