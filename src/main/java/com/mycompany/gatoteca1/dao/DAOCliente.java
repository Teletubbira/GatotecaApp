/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.dao;


import com.mycompany.gatoteca1.App;
import com.mycompany.gatoteca1.modelos.Cliente;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
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
public class DAOCliente implements Dao<Cliente> {

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

//        System.out.println("Las properties son: " + host + port);

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }

    public void desconectar() throws SQLException {
        conexion.close();
    }

    public DAOCliente() throws ClassNotFoundException, SQLException, IOException {
        conectar();
    }

    @Override
    public Cliente get(int id) throws SQLException {
        // TODO Auto-generated method stub
        Cliente cliente = new Cliente();
        String sql = "SELECT * FROM cliente where idCliente = " + id;

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        resultado.next();

        cliente.setId(resultado.getInt(1));
        cliente.setNombre(resultado.getString(2));
        cliente.setApellido_p(resultado.getString(3));
        cliente.setApellido_s(resultado.getString(4));

        return cliente;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean resultado = true;  
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
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
    public boolean save(Cliente cliente) throws SQLException {
        boolean resultado = true;
        String sql = "INSERT INTO cliente (nombre, apellido_p, apellido_s) VALUES(?,?,?)";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, cliente.getNombre());
        sentencia.setString(2, cliente.getApellido_p());
        sentencia.setString(3, cliente.getApellido_s());

                try {
            sentencia.executeUpdate();
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean update(Cliente cliente) throws SQLException {
        boolean resultado = true;
        String sql = "UPDATE cliente SET ( nombre, apellido_p, apellido_s) = (?,?,?) WHERE idCliente = id";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, cliente.getNombre());
        sentencia.setString(2, cliente.getApellido_p());
        sentencia.setString(3, cliente.getApellido_s());

                try {
            sentencia.executeUpdate();
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public List<Cliente> getAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(resultado.getInt(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido_p(resultado.getString(3));
            cliente.setApellido_s(resultado.getString(4));
            clientes.add(cliente);
        }

        return clientes;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        DAOCliente dcliente = new DAOCliente();
        // Cliente gato = DAOgato.get(1);
        Cliente cliente = new Cliente("Laura", "Pausini", "Gomez");
        Cliente cliente2 = new Cliente("Bob", "Garcia", "Garcia");
        Cliente cliente3 = new Cliente("Ren", "Tomogashi", "Sakura");
        dcliente.save(cliente);
        dcliente.save(cliente2);
        dcliente.save(cliente3);

        System.out.println(dcliente.get(1));

    }

}
