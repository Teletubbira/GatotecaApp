/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.modelos;

import java.sql.Date;

/** Clase acogida que nos dara los datos de la acogida de gato por clientes con su fecha
 *
 * @author Irasema
 */
public class Acogida {

    private int idAcogida;
    private int idCliente;
    private int idGato;
    private Date fecha;

    /** Constructor con parametros de la clase acogida
     *
     * @param idAcogida
     * @param idCliente
     * @param idGato
     * @param fecha
     */
    public Acogida(int idAcogida, int idCliente, int idGato, Date fecha) {
        this.idAcogida = idAcogida;
        this.idCliente = idCliente;
        this.idGato = idGato;
        this.fecha = fecha;
    }

    /** Constructor con parametros sin la id de acogida de la clase acogida
     *
     * @param idCliente
     * @param idGato
     * @param fecha
     */
    public Acogida(int idCliente, int idGato, Date fecha) {
        this.idCliente = idCliente;
        this.idGato = idGato;
        this.fecha = fecha;
    }

    /** Constructor sin parametros de la clase Acogida
     *
     */
    public Acogida() {
    }

    /** Metodo para obtener el IdAcogida
     *
     * @return
     */
    public int getIdAcogida() {
        return idAcogida;
    }

    /** Metodo para darle valor a IdAcogida
     *
     * @param idAcogida
     */
    public void setIdAcogida(int idAcogida) {
        this.idAcogida = idAcogida;
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
        return "Acogida{" + "idAcogida=" + idAcogida + ", idCliente=" + idCliente + ", idGato=" + idGato + ", fecha=" + fecha + '}';
    }

}
