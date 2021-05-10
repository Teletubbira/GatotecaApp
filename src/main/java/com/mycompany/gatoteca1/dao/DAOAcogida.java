/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.dao;

import com.mycompany.gatoteca1.App;
import com.mycompany.gatoteca1.modelos.Acogida;
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
public class DAOAcogida implements Dao<Acogida> {

    private Connection conexion;

    public void conectar() throws ClassNotFoundException, SQLException, IOException {

        Properties configuration = new Properties();
        
        configuration.load(new FileInputStream(new File(App.class.getResource("connectionDB.properties").getPath())));
        // configuration.load(new FileInputStream(new File("C:\\Users\\Irasema\\Documents\\NetBeansProjects\\Gatoteca1\\src\\main\\resources\\com\\mycompany\\gatoteca1\\connectionDB.properties")));
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

    public DAOAcogida() throws ClassNotFoundException, SQLException, IOException {
        conectar();
    }

    @Override
    public Acogida get(int id) throws SQLException {
        // TODO Auto-generated method stub
        Acogida acogida = new Acogida();
        String sql = "SELECT * FROM acogida where idAcogida = " + id;

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        resultado.next();

        acogida.setIdAcogida(resultado.getInt(1));
        acogida.setIdCliente(resultado.getInt(2));
        acogida.setIdGato(resultado.getInt(3));

        return acogida;
    }

    @Override
    public boolean delete(int id) throws SQLException {
         boolean resultado = true;
        String sql = "DELETE FROM acogida WHERE idAcogida = ?";
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
    public boolean save(Acogida acogida) throws SQLException {
        boolean resultado = true;
        String sql = "INSERT INTO acogida (idCliente, idGato, fecha) VALUES(?,?,?)";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, acogida.getIdCliente());
        sentencia.setInt(2, acogida.getIdGato());
        sentencia.setDate(3, acogida.getFecha());
        try {
            sentencia.executeUpdate();
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean update(Acogida acogida) throws SQLException {
        String sql = "UPDATE acogida SET (idCliente, idGato, fecha) = (?,?,?) WHERE idAcogida = id";
        boolean resultado = true;
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, acogida.getIdCliente());
        sentencia.setInt(2, acogida.getIdGato());
        sentencia.setDate(3, acogida.getFecha());

        try {
            sentencia.executeUpdate();
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public List<Acogida> getAll() throws SQLException {
        List<Acogida> acogidas = new ArrayList<>();
        String sql = "SELECT * FROM acogida";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Acogida acogida = new Acogida();
            acogida.setIdAcogida(resultado.getInt(1));
            acogida.setIdCliente(resultado.getInt(1));
            acogida.setIdGato(resultado.getInt(1));
            acogida.setFecha(resultado.getDate(1));
            acogidas.add(acogida);
        }

        return acogidas;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        DAOAcogida dacogida = new DAOAcogida();
          String str = "2015-03-31";
        Date date = Date.valueOf(str);

        Acogida acogida = new Acogida(1, 2, date );
        dacogida.save(acogida);

    }
}
