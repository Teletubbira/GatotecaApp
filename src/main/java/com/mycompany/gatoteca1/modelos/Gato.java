/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.modelos;

import java.sql.Date;



/**
 *
 * @author Irasema
 */
public class Gato {
    private int id;
    private String raza;
    private String nombre;
    private String sexo;
    private Date fecha_nacimiento;

    public Gato(int id, String raza, String nombre, String sexo, Date fecha_nacimiento) {
        this.id = id;
        this.raza = raza;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Gato(String raza, String nombre, String sexo, Date fecha_nacimiento) {
        this.raza = raza;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Gato() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Gato{" + "id=" + id + ", raza=" + raza + ", nombre=" + nombre + ", sexo=" + sexo + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }
    
    
    
    
}
