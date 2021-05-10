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
public class Acogida {

    private int idAcogida;
    private int idCliente;
    private int idGato;
    private Date fecha;

    public Acogida(int idAcogida, int idCliente, int idGato, Date fecha) {
        this.idAcogida = idAcogida;
        this.idCliente = idCliente;
        this.idGato = idGato;
        this.fecha = fecha;
    }

    public Acogida(int idCliente, int idGato, Date fecha) {
        this.idCliente = idCliente;
        this.idGato = idGato;
        this.fecha = fecha;
    }

    public Acogida() {
    }

    public int getIdAcogida() {
        return idAcogida;
    }

    public void setIdAcogida(int idAcogida) {
        this.idAcogida = idAcogida;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdGato() {
        return idGato;
    }

    public void setIdGato(int idGato) {
        this.idGato = idGato;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Acogida{" + "idAcogida=" + idAcogida + ", idCliente=" + idCliente + ", idGato=" + idGato + ", fecha=" + fecha + '}';
    }

}
