package com.e.agenda.model;

import java.util.List;

public class Agenda_pendienteLista {
    private int estado;
    private List<Agenda_pendiente> datos= null; ;
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public List<Agenda_pendiente> getPendientes() {
        return datos;
    }
    public void setPendientes(List<Agenda_pendiente> pendientes) {
        this.datos = pendientes;
    }

}
