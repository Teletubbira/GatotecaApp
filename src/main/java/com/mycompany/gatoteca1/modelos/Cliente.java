/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.modelos;

/** Clase que nos da los datos de los clientes de la gatoteca
 *
 * @author Irasema
 */
public class Cliente {
    private int id;
    private String nombre;
    private String apellido_p;
    private String apellido_s;

    /** Constructor con parametros de la clase cliente
     *
     * @param id
     * @param nombre
     * @param apellido_p
     * @param apellido_s
     */
    public Cliente(int id, String nombre, String apellido_p, String apellido_s) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_s = apellido_s;
    }

    /** Constructor con parametros sin el id del cliente
     *
     * @param nombre
     * @param apellido_p
     * @param apellido_s
     */
    public Cliente(String nombre, String apellido_p, String apellido_s) {
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_s = apellido_s;
    }

    /** Constructor sin parametros
     *
     */
    public Cliente() {
    }

    /** Metodo para obtener el id del cliente
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /** Metodo para darle valor al id del cliente
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /** Metodo para conseguir el nombre del cliente
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /** Metodo para darle valor al nombre del cliente
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Metodo para obtener el primer apellido del cliente
     *
     * @return
     */
    public String getApellido_p() {
        return apellido_p;
    }

    /** Metodo para darle valor al primer apellido del cliente
     *
     * @param apellido_p
     */
    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    /** Metodo para obtener el segundo apellido del cliente
     *
     * @return
     */
    public String getApellido_s() {
        return apellido_s;
    }

    /** Metodo para darle valor al segundo apellido del cliente
     *
     * @param apellido_s
     */
    public void setApellido_s(String apellido_s) {
        this.apellido_s = apellido_s;
    }

   

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido_p=" + apellido_p + ", apellido_s=" + apellido_s + '}';
    }
    
}
