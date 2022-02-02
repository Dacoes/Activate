package com.unicauca.activate.model;

public class Asistence {
    private Long identificacionUsuario;
    private Long identificacionEvento;

    

    public Asistence(Long identificacionUsuario, Long identificacionEvento) {
        this.identificacionUsuario = identificacionUsuario;
        this.identificacionEvento = identificacionEvento;
    }
    public Long getIdentificacionUsuario() {
        return identificacionUsuario;
    }
    public void setIdentificacionUsuario(Long identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }
    public Long getIdentificacionEvento() {
        return identificacionEvento;
    }
    public void setIdentificacionEvento(Long identificacionEvento) {
        this.identificacionEvento = identificacionEvento;
    }
    @Override
    public String toString() {
        return "Asistence [identificacionEvento=" + identificacionEvento + ", identificacionUsuario="
                + identificacionUsuario + "]";
    }
    
    
}
