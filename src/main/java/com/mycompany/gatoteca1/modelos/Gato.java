/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.modelos;

import java.sql.Date;

/**
 * Clase gato que hereda de la clase animal
 *
 * @author Irasema
 */
public class Gato extends Animal {

    private int id;

    /**
     * Constructor con parametros, hereda atributos de la clase padre animal
     *
     * @param id variable que hace referencia al id del gato
     * @param raza variable que hace referencia a la raza del gato
     * @param nombre variable que hace referencia al nombre del gato
     * @param sexo variable que hace referencia al sexo del gato
     * @param fecha_nacimiento variable que hace referencia a la fecha de
     * nacimiento del gato
     */
    public Gato(int id, String raza, String nombre, String sexo, Date fecha_nacimiento) {
        super(raza, nombre, sexo, fecha_nacimiento);
        this.id = id;

    }

    /**
     * Constructor con parametros, hereda atributos de la clase padre animal
     *
     * @param raza variable que hace referencia a la raza del gato
     * @param nombre variable que hace referencia al nombre del gato
     * @param sexo variable que hace referencia al sexo del gato
     * @param fecha_nacimiento variable que hace referencia a la fecha de
     * nacimiento del gato
     */
    public Gato(String raza, String nombre, String sexo, Date fecha_nacimiento) {
        super(raza, nombre, sexo, fecha_nacimiento);

    }

    /**
     * Constructor vacio de la clase gato
     *
     */
    public Gato() {
    }

    /**
     * Metodo para obtener el id del gato
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo para darle valor al id del gato
     *
     * @param id variable que hace referencia al id del gato
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "-" + getId() + ": " + getNombre() + " es de la raza " + getRaza() + ", es del sexo " + getSexo() + " y su fecha de nacimiento es " + getFecha_nacimiento();
    }

}
