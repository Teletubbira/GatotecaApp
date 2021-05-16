/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1;

import com.mycompany.gatoteca1.dao.DAOCliente;
import com.mycompany.gatoteca1.modelos.Cliente;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Controlador que da de alta clientes en la base de datos
 * FXML Controller class
 *
 * @author Irasema
 */
public class DardealtaclienteController implements Initializable {

    @FXML
    private TextField nombre;
    @FXML
    private TextField p_apellido;
    @FXML
    private TextField s_apellido;
    @FXML
    private Button aceptar;
    @FXML
    private Button cancelar;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    /** Metodo que guarda los datos introducidos por el usuario sobre el nuevo cliente
     * 
     */
    @FXML
    private void darDeAltaCliente(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        DAOCliente dcliente = new DAOCliente();
        Cliente cliente = new Cliente();

        cliente.setNombre(nombre.getText());
        cliente.setApellido_p(p_apellido.getText());
        cliente.setApellido_s(s_apellido.getText());

        if (dcliente.save(cliente)) {
            Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
            errorAlert.setContentText("Se ha dado de alta con exito");
            errorAlert.showAndWait();
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("No se ha podido dar de alta");
            errorAlert.showAndWait();
        }
        dcliente.desconectar();
    }
    /** Metodo que cierra la ventana actual
     * 
     */
    @FXML
    private void closeWindow(MouseEvent event) {
        Stage stage = (Stage) cancelar.getScene().getWindow();

        stage.close();
    }

}
