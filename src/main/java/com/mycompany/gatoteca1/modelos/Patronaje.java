/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.modelos;

import java.sql.Date;

/** Clase patronaje que nos dara los datos de la patronaje de gato por clientes con su fecha
 *
 * @author Irasema
 */
public class Patronaje {

    private int idPatronaje;
    private int idCliente;
    private int idGato;
    private Date fecha;

    /** Constructor con parametros de la clase patronaje
     *
     * @param idPatronaje
     * @param idCliente
     * @param idGato
     * @param fecha
     */
    public Patronaje(int idPatronaje, int idCliente, int idGato, Date fecha) {
        this.idPatronaje = idPatronaje;
        this.idCliente = idCliente;
        this.idGato = idGato;
        this.fecha = fecha;
    }

    /** Constructor con parametros sin la id de patronaje de la clase patronaje
     *
     * @param idCliente
     * @param idGato
     * @param fecha
     */
    public Patronaje(int idCliente, int idGato, Date fecha) {
        this.idCliente = idCliente;
        this.idGato = idGato;
        this.fecha = fecha;
    }

    /** Constructor sin parametros de la clase Patronaje
     *
     */
    public Patronaje() {
    }

    /** Metodo para obtener el IdPatronaje
     *
     * @return
     */
    public int getIdPatronaje() {
        return idPatronaje;
    }

    /** Metodo para darle valor a IdPatronaje
     *
     * @param idPatronaje
     */
    public void setIdPatronaje(int idPatronaje) {
        this.idPatronaje = idPatronaje;
    }

    /** Metodo para obtener IdCliente
     *
     * @return
     */
    public int getIdCliente() {
        return idCliente;
    }

    /** Metodo para darle valor a IdCliente
     *
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /** Metodo para obtener el IdGato
     *
     * @return
     */
    public int getIdGato() {
        return idGato;
    }

    /** Metodo para darle valor a IdGato
     *
     * @param idGato
     */
    public void setIdGato(int idGato) {
        this.idGato = idGato;
    }

    /** Metodo para obtener Fecha
     *
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /** Metodo para darle valor a Fecha
     *
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Patronaje{" + "idPatronaje=" + idPatronaje + ", idCliente=" + idCliente + ", idGato=" + idGato + ", fecha=" + fecha + '}';
    }

}
