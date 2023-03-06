package com.example.demo.entitys;

import java.util.Date;

public class Children {

    private String id;
    private String nombre;
    private String descripcion;
    private int idUser;
    private Date fecha;
    //Estado es un true o false, true será que estara activo. y podra recibir regalos.
    private Boolean estado;
/** GENERAMOS LOS GETTERS AND SETTERS */

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
