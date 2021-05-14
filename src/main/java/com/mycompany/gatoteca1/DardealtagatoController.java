/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1;

import com.mycompany.gatoteca1.dao.DAOGato;
import com.mycompany.gatoteca1.modelos.Gato;
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
public class DardealtagatoController implements Initializable {

    @FXML
    private Button aceptar;
    @FXML
    private Button cancelar;
    @FXML
    private TextField nombreGato;
    @FXML
    private DatePicker fechaNacimiento;
    @FXML
    private TextField raza;
    @FXML
    private TextField sexo;

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
    private void darDeAltaGatito(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        DAOGato dgato = new DAOGato();
        Gato gato = new Gato();

        gato.setNombre(nombreGato.getText());
        gato.setFecha_nacimiento(java.sql.Date.valueOf(fechaNacimiento.getValue())); // llamando a la clase java sql Date al metodo value of con el valor del datepicker
        gato.setRaza(raza.getText());
        gato.setSexo(sexo.getText());

        if (dgato.save(gato)) {
            Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
            errorAlert.setContentText("Se ha dado de alta con exito");
            errorAlert.showAndWait();
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("No se ha podido dar de alta");
            errorAlert.showAndWait();
        }

    }

    @FXML
    private void closeWindow(MouseEvent event) {
        Stage stage = (Stage) cancelar.getScene().getWindow();

        stage.close();
    }

}
