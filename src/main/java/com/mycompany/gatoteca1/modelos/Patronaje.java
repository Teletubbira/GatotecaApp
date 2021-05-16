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
     * @param idPatronaje variable que hace referencia al id del patronaje
     * @param idCliente variable que hace referencia al id del cliente
     * @param idGato variable que hace referencia al id del gato
     * @param fecha variable que hace referencia a la fecha de adopcion
     */
    public Patronaje(int idPatronaje, int idCliente, int idGato, Date fecha) {
        this.idPatronaje = idPatronaje;
        this.idCliente = idCliente;
        this.idGato = idGato;
        this.fecha = fecha;
    }

    /** Constructor con parametros sin la id de patronaje de la clase patronaje
     *
     * @param idCliente variable que hace referencia al id del cliente
     * @param idGato variable que hace referencia al id del gato
     * @param fecha variable que hace referencia a la fecha de adopcion
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
     * @return idPatronaje
     */
    public int getIdPatronaje() {
        return idPatronaje;
    }

    /** Metodo para darle valor a IdPatronaje
     *
     * @param idPatronaje variable que hace referencia al id del patronaje
     */
    public void setIdPatronaje(int idPatronaje) {
        this.idPatronaje = idPatronaje;
    }

    /** Metodo para obtener IdCliente
     *
     * @return idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /** Metodo para darle valor a IdCliente
     *
     * @param idCliente variable que hace referencia al id del cliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /** Metodo para obtener el IdGato
     *
     * @return idGato
     */
    public int getIdGato() {
        return idGato;
    }

    /** Metodo para darle valor a IdGato
     *
     * @param idGato variable que hace referencia al id del gato
     */
    public void setIdGato(int idGato) {
        this.idGato = idGato;
    }

    /** Metodo para obtener Fecha
     *
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /** Metodo para darle valor a Fecha
     *
     * @param fecha variable que hace referencia a la fecha del patronaje
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Patronaje{" + "idPatronaje=" + idPatronaje + ", idCliente=" + idCliente + ", idGato=" + idGato + ", fecha=" + fecha + '}';
    }

}
