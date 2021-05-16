/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.dao;

import com.mycompany.gatoteca1.App;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/** Clase que valida que los datos proporcionados en el login se encuentren en la base de datos
 *
 * @author Irasema
 */
public class LoginValidate {

    private Connection conexion;

    /** Metodo que conecta con la base de datos
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

    /** Metodo que desconecta de la base de datos
     *
     * @throws SQLException
     */
    public void desconectar() throws SQLException {
        conexion.close();
    }

    /** Constructor de LoginValidate
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public LoginValidate() throws ClassNotFoundException, SQLException, IOException {
        conectar();
    }

    /** Metodo que comprueba si el usuario y contraseña introducidos se encuentran en la base de datos
     *
     * @param user variable que hace referencia al nombre de usuario
     * @param password variable que hace referencia a la contraseña del usuario
     * @return devuelve true si los datos introducidos son validos y false en caso contrario
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public boolean validate(String user, String password) throws ClassNotFoundException, SQLException, IOException {
        boolean esValido = false;

        String sql = "SELECT USER, PASSWORD FROM USUARIO WHERE USER = ? AND PASSWORD = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, user);
        sentencia.setString(2, password);
        ResultSet result = sentencia.executeQuery();

        if (result.next()) {
            esValido = true;
        }

        return esValido;
    }

}
