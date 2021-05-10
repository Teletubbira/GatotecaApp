/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void darDeAltaAdopcion(MouseEvent event) {
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        Stage stage = (Stage) cancelar.getScene().getWindow();

        stage.close();
    }

}
