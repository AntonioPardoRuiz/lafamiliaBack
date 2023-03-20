package com.example.demo.entitys;

import java.util.Date;

public class Gifts {

	private String id;
    private String nombre;
    private String descripcion;
    private int nombreHijo;
    private int idUser;
    private float precio;
    private Date fecha;
    private String estado;
    private String familiar;

    /*GENERAMOS LOS GETTERS&SETTERS*/

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

    public int getNombreHijo() {
        return this.nombreHijo;
    }

    public void setNombreHijo(int nombreHijo) {
        this.nombreHijo = nombreHijo;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFamiliar() {
        return familiar;
    }

    public void setFamiliar(String familiar) {
        this.familiar = familiar;
    }


}