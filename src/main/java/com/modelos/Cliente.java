/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelos;

/**
 *
 * @author Irasema
 */
public class Cliente {
    private int id;
    private String nombre;
    private String apellido_p;
    private String apellido_s;

    public Cliente(int id, String nombre, String apellido_p, String apellido_s) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_s = apellido_s;
    }

    public Cliente(String nombre, String apellido_p, String apellido_s) {
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_s = apellido_s;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_s() {
        return apellido_s;
    }

    public void setApellido_s(String apellido_s) {
        this.apellido_s = apellido_s;
    }

   

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido_p=" + apellido_p + ", apellido_s=" + apellido_s + '}';
    }
    
}
