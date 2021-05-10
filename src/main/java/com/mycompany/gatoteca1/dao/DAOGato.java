/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.dao;

import com.mycompany.gatoteca1.App;
import com.mycompany.gatoteca1.modelos.Gato;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Irasema
 */
public class DAOGato implements Dao<Gato> {

    private Connection conexion;

    public void conectar() throws ClassNotFoundException, SQLException, IOException {

        Properties configuration = new Properties();


       configuration.load(new FileInputStream(new File(App.class.getResource("connectionDB.properties").getPath())));
        String host = configuration.getProperty("host");
        String port = configuration.getProperty("port");
        String name = configuration.getProperty("name");
        String username = configuration.getProperty("username");
        String password = configuration.getProperty("password");

        //System.out.println("Las properties son: " + host + port);
        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }

    public void desconectar() throws SQLException {
        conexion.close();
    }

    public DAOGato() throws ClassNotFoundException, SQLException, IOException {
        conectar();
    }

    @Override
    public Gato get(int id) throws SQLException {
        // TODO Auto-generated method stub
        Gato gato = null; //Inicializado a null
        String sql = "SELECT * FROM gato where idgato = " + id;

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();

        if (resultado.next()) { //En caso de que exista el gato, le doy valores
            gato = new Gato();
            gato.setId(resultado.getInt(1));
            gato.setRaza(resultado.getString(2));
            gato.setNombre(resultado.getString(3));
            gato.setSexo(resultado.getString(4));
            gato.setFecha_nacimiento(resultado.getDate(5));
        }
        return gato;
    }
     public Gato buscarPorNombre(String nombre) throws SQLException {
        // TODO Auto-generated method stub
        Gato gato = null; //Inicializado a null
        String sql = "SELECT * FROM gato where nombre = " + nombre;

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();

        if (resultado.next()) { //En caso de que exista el gato, le doy valores
            gato = new Gato();
            gato.setId(resultado.getInt(1));
            gato.setRaza(resultado.getString(2));
            gato.setNombre(resultado.getString(3));
            gato.setSexo(resultado.getString(4));
            gato.setFecha_nacimiento(resultado.getDate(5));
        }
        return gato;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean resultado = true;
        String sql = "DELETE FROM gato WHERE idGato = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        try {
            sentencia.executeUpdate();
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean save(Gato gato) throws SQLException {
        boolean resultado = true;
        String sql = "INSERT INTO gato (raza, nombre, sexo, fecha_nacimiento) VALUES(?,?,?,?)";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, gato.getRaza());
        sentencia.setString(2, gato.getNombre());
        sentencia.setString(3, gato.getSexo());
        sentencia.setDate(4, gato.getFecha_nacimiento());

        try {
            sentencia.executeUpdate();
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean update(Gato gato) throws SQLException {
        boolean resultado = true;
        String sql = "UPDATE gato SET (raza, nombre, sexo, fecha_nacimiento) = (?,?,?,?) WHERE idGato = id";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, gato.getRaza());
        sentencia.setString(2, gato.getNombre());
        sentencia.setString(3, gato.getSexo());
        sentencia.setDate(4, gato.getFecha_nacimiento());

        try {
            sentencia.executeUpdate();
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public List<Gato> getAll() throws SQLException {
        List<Gato> gatos = new ArrayList<>();
        String sql = "SELECT * FROM gato";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Gato gato = new Gato();
            gato.setId(resultado.getInt(1));
            gato.setRaza(resultado.getString(2));
            gato.setNombre(resultado.getString(3));
            gato.setSexo(resultado.getString(4));
            gato.setFecha_nacimiento(resultado.getDate(5));
            gatos.add(gato);
        }

        return gatos;
    }

    public List<Gato> getAdoptables() throws SQLException {
        List<Gato> gatos = new ArrayList<>();
        String sql = "SELECT * FROM gato WHERE idGato NOT IN(SELECT IDGATO FROM ACOGIDA)";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Gato gato = new Gato();
            gato.setId(resultado.getInt(1));
            gato.setRaza(resultado.getString(2));
            gato.setNombre(resultado.getString(3));
            gato.setSexo(resultado.getString(4));
            gato.setFecha_nacimiento(resultado.getDate(5));
            gatos.add(gato);
        }

        return gatos;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        DAOGato DAOgato = new DAOGato();
        // Gato gato = DAOgato.get(1);
        String str = "2015-03-31";
        Date date = Date.valueOf(str);

        Gato gato = new Gato("Persa", "Misifu", "F", date);
        Gato gato2 = new Gato("Siames", "Elliot", "M", date);
        Gato gato3 = new Gato("Comun", "Peque", "M", date);
        DAOgato.save(gato);
        DAOgato.save(gato2);
        DAOgato.save(gato3);

        System.out.println(DAOgato.getAll());

        DAOgato.delete(1);

        System.out.println(DAOgato.getAll());

    }
}
