/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1;

import com.mycompany.gatoteca1.dao.DAOAcogida;
import com.mycompany.gatoteca1.modelos.Acogida;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Irasema
 */
public class AdoptarController implements Initializable {

    @FXML
    private Button aceptar;
    @FXML
    private Button cancelar;
    @FXML
    private TextField idCliente;
    @FXML
    private TextField idGato;
    @FXML
    private DatePicker fechaAdopcion;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void darDeAltaAdopcion(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        DAOAcogida dacogida = new DAOAcogida();
        Acogida acogida = new Acogida();
        int idC = Integer.parseInt(idCliente.getText());
        acogida.setIdCliente(idC);
        int idG = Integer.parseInt(idGato.getText());
        acogida.setIdGato(idG);
        acogida.setFecha(java.sql.Date.valueOf(fechaAdopcion.getValue()));

        if (dacogida.validarAdopcion(idG)) {
            if (dacogida.save(acogida)) {
                Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
                errorAlert.setContentText("Adopcion realizada");
                errorAlert.showAndWait();
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setContentText("Error");
                errorAlert.showAndWait();

            }

        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("El gato ya ha sido adoptado.");
            errorAlert.showAndWait();
        }

    }

    @FXML
    private void closeWindow(MouseEvent event) {
        Stage stage = (Stage) cancelar.getScene().getWindow();

        stage.close();
    }

}
