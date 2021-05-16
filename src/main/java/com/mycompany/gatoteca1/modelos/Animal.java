/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.modelos;

import java.sql.Date;

/** Clase padre con los atributos de los animales de la gatoteca
 *
 * @author Irasema
 */
public abstract class Animal {
    private String raza;
    private String nombre;
    private String sexo;
    private Date fecha_nacimiento;

    /**
     *
     * @param raza
     * @param nombre
     * @param sexo
     * @param fecha_nacimiento
     */
    public Animal(String raza, String nombre, String sexo, Date fecha_nacimiento) {
        this.raza = raza;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /** Constructor sin parametros de la clase Animal
     *
     */
    public Animal() {
    }

    /** Metodo para obtener la raza
     *
     * @return
     */
    public String getRaza() {
        return raza;
    }

    /** Metodo para darle valor a raza
     *
     * @param raza
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /** Metodo para obtener el nombre del animal
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /** Metodo para darle valor al nombre del animal
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Metodo para obtener el sexo del animal
     *
     * @return
     */
    public String getSexo() {
        return sexo;
    }

    /** Metodo para darle valor al sexo del animal
     *
     * @param sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /** Metodo para obtener la fecha de nacimiento del animal
     *
     * @return
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /** Metodo para darle valor a la feca de nacimiento del animal
     *
     * @param fecha_nacimiento
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    
}

