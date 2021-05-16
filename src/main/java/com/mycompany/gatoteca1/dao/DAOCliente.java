/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.dao;

import com.mycompany.gatoteca1.App;
import com.mycompany.gatoteca1.modelos.Cliente;
import com.mycompany.gatoteca1.modelos.Gato;
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
 * Clase que se encarga de gestionar la entidad cliente con la base de datos
 *
 * @author Irasema
 */
public class DAOCliente implements Dao<Cliente> {

    private Connection conexion;

    /**
     * Metodo para conectar con la base de datos
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
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

    /**
     * Metodo para desconectar de la base de datos
     *
     * @throws SQLException
     */
    public void desconectar() throws SQLException {
        conexion.close();
    }

    /**
     * Constructor de DAOCliente
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public DAOCliente() throws ClassNotFoundException, SQLException, IOException {
        conectar();
    }

    /**
     * Metodo para buscar un cliente en la base de datos mediante su ID
     *
     * @param id variable que hace referencia al id del cliente
     * @return devuelve el cliente solicitado, null en caso contrario
     * @throws SQLException
     */
    @Override
    public Cliente get(int id) throws SQLException {
        // TODO Auto-generated method stub
        Cliente cliente = null; // inicializado a null
        String sql = "SELECT * FROM cliente where idCliente = " + id;

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();

        if (resultado.next()) {
            cliente = new Cliente();
            cliente.setId(resultado.getInt(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido_p(resultado.getString(3));
            cliente.setApellido_s(resultado.getString(4));
        }

        return cliente;
    }

    /**
     * Metodo para eliminar un cliente mediante su ID
     *
     * @param id variable que hace referencia al id del cliente
     * @return devuelve true si se ha podido eliminar el cliente, false en caso contrario
     * @throws SQLException
     */
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

    /**
     * Metodo para guardar los datos de un cliente (nombre y apellidos)
     *
     * @param cliente variable que hace refrencia al objeto cliente
     * @return devuelve true si se han podido guardar los datos del cliente, false en caso contrario
     * @throws SQLException
     */
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

    /**
     * Metodo para modificar los datos de un cliente
     *
     * @param cliente variable que hace referencia al objeto cliente
     * @return devuelve true si se han podido modificar los datos del cliente, false en caso contrario
     * @throws SQLException
     */
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

    /**
     * Metodo para ver una lista de todos los clientes
     *
     * @return devuelve la lista de todos los clientes
     * @throws SQLException
     */
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

    /**
     * Metodo para ver una lista de los gatos adoptados por un cliente buscando
     * por la ID del cliente
     *
     * @param id variable que hace referencia al id del cliente
     * @return devuelve los gatos que han sido adoptados por ese cliente
     * @throws SQLException
     */
    public List<Gato> getGatitosAdoptados(int id) throws SQLException {
        List<Gato> gatos = new ArrayList<>();

        String sql = "SELECT GATO.* from acogida inner join gato ON acogida.idGato = gato.idgato WHERE idCliente = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
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

    /**
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
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
