/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.dao;

import com.mycompany.gatoteca1.App;
import com.mycompany.gatoteca1.modelos.Patronaje;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Clase que se encarga de gestionar la entidad patronaje con la base de datos
 *
 * @author Irasema
 */
public class DAOPatronaje implements Dao<Patronaje> {

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

        //System.out.println("Las properties son: " + host + port);
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
     * Constructor de la clase DAOpatronaje, una vez se inicializa se conecta
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public DAOPatronaje() throws ClassNotFoundException, SQLException, IOException {
        conectar();
    }

    /**
     * Metodo para buscar una patronaje en la base de datos por su ID
     *
     * @param id variable que hace referencia al id de patronaje
     * @return devuelve los datos de esa patronaje
     * @throws SQLException
     */
    @Override
    public Patronaje get(int id) throws SQLException {
        // TODO Auto-generated method stub
        Patronaje patronaje = new Patronaje();
        String sql = "SELECT * FROM patronaje where idpatronaje = " + id;

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        resultado.next();

        patronaje.setIdPatronaje(resultado.getInt(1));
        patronaje.setIdCliente(resultado.getInt(2));
        patronaje.setIdGato(resultado.getInt(3));

        return patronaje;
    }

    /**
     * Metodo para eliminar una patronaje de la base de datos por su ID
     *
     * @param id variable que hace referencia al id de patronaje
     * @return devuelve true si se ha podido eliminar, false en caso contrario
     * @throws SQLException
     */
    @Override
    public boolean delete(int id) throws SQLException {
        boolean resultado = true;
        String sql = "DELETE FROM patronaje WHERE idpatronaje = ?";
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
     * Metodo para guardar una patronaje con idCliente, idGato y fecha de
     * adopcion
     *
     * @param patronaje variable que hace referencia al objeto patronaje
     * @return devuelve true si se han podido guardar los datos, false en caso
     * contrario
     * @throws SQLException
     */
    @Override
    public boolean save(Patronaje patronaje) throws SQLException {
        boolean resultado = true;
        String sql = "INSERT INTO patronaje (idCliente, idGato, fecha) VALUES(?,?,?)";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, patronaje.getIdCliente());
        sentencia.setInt(2, patronaje.getIdGato());
        sentencia.setDate(3, patronaje.getFecha());
        try {
            sentencia.executeUpdate();
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para modificar los datos en una patronaje existente
     *
     * @param patronaje variable que hace referencia al objeto patronaje
     * @return devuelve true si se han podido modificar los datos, false en caso
     * contrario
     * @throws SQLException
     */
    @Override
    public boolean update(Patronaje patronaje) throws SQLException {
        String sql = "UPDATE patronaje SET (idCliente, idGato, fecha) = (?,?,?) WHERE idpatronaje = id";
        boolean resultado = true;
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, patronaje.getIdCliente());
        sentencia.setInt(2, patronaje.getIdGato());
        sentencia.setDate(3, patronaje.getFecha());

        try {
            sentencia.executeUpdate();
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para ver una lista de todas las patronajes
     *
     * @return devuelve todas las patronajes
     * @throws SQLException
     */
    @Override
    public List<Patronaje> getAll() throws SQLException {
        List<Patronaje> patronajes = new ArrayList<>();
        String sql = "SELECT * FROM patronaje";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Patronaje patronaje = new Patronaje();
            patronaje.setIdPatronaje(resultado.getInt(1));
            patronaje.setIdCliente(resultado.getInt(1));
            patronaje.setIdGato(resultado.getInt(1));
            patronaje.setFecha(resultado.getDate(1));
            patronajes.add(patronaje);
        }

        return patronajes;
    }

    /**
     * Metodo para comprobar si un gato ha sido adoptado
     *
     * @param idGato variable que hace referencia al id del gato
     * @return devuelve true si el gato ha sido adoptado, false en caso
     * contrario
     * @throws SQLException
     */
    public boolean validarAdopcion(int idGato, int idCliente) throws SQLException {
        boolean resultado = true;
        String sql = "SELECT IDGATO FROM patronaje WHERE IDGATO = ? AND IDCLIENTE = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, idGato);
        sentencia.setInt(2, idCliente);
        ResultSet result = sentencia.executeQuery();

        if (result.next()) {
            resultado = false;
        } else {
            resultado = true;
        }

        return resultado;
    }

    public int buscarAdopcionesPorAño(int fecha) throws SQLException {
        String sql = "CALL gatoteca.adopcionesPorDia(?, ?)";
        CallableStatement cstmt = conexion.prepareCall(sql);
        cstmt.setInt(1, fecha);
        cstmt.registerOutParameter(2, Types.INTEGER);
        cstmt.executeUpdate();
        int adopciones = cstmt.getInt(2);

        return adopciones;
    }

    /**
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        DAOPatronaje dpatronaje = new DAOPatronaje();
        String str = "2015-03-31";
        Date date = Date.valueOf(str);

        Patronaje patronaje = new Patronaje(1, 2, date);
        dpatronaje.save(patronaje);

    }
}
