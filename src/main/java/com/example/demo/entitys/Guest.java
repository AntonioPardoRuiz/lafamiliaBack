package com.example.demo.entitys;

import java.util.Date;

public class Guest {

	private String id;
    private String email;
    private String password;
    private String confirmPassword;
    private String idUser;
    private String nombre;
    private String apellido;
    private String telefono;
    private String descripcion;
    private String dni;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String codigoPostal;
    private String pais;
    private String otros;
    private Date fechaAlta;
    private String idRol;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getOtros() {
        return this.otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public Date getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        //Seteamos la fecha del dia.Cada vez que se da de alta.
        this.fechaAlta = fechaAlta;
    }
  
    public String getIdRol() {
        return this.idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }


}
