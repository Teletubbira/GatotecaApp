/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1;

import com.mycompany.gatoteca1.dao.DAOGato;
import com.mycompany.gatoteca1.modelos.Gato;
import com.mycompany.gatoteca1.modelos.Raza;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador que gestiona la modificacion de los datos del gato FXML
 * Controller class
 *
 * @author Irasema
 */
public class UpdateGatitoController implements Initializable {

    @FXML
    private Button aceptar;
    @FXML
    private Button cancelar;
    @FXML
    private TextField nombreGato;
    @FXML
    private DatePicker fecha;
    @FXML
    private ComboBox<Raza> raza;
    @FXML
    private TextField sexo;
    @FXML
    private TextField IDGato;
    @FXML
    private Button buscarGato;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        raza.getItems().setAll(Raza.values());
    }

    /**
     * Metodo que cierra la ventana actual
     *
     */
    @FXML
    private void closeWindow(MouseEvent event) {
        Stage stage = (Stage) cancelar.getScene().getWindow();

        stage.close();
    }

    /**
     * Metodo que muestra los datos del gato mediante el id introducido por el
     * usuario
     *
     */
    @FXML
    private void buscarGato(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        DAOGato dgato = new DAOGato();
        int idG = Integer.parseInt(IDGato.getText());

        Gato gato = dgato.get(idG);
        dgato.desconectar();

        if (gato == null) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("No se ha podido encontrar el gato");
            errorAlert.showAndWait();
        } else {
            nombreGato.setText(gato.getNombre());
            fecha.setValue(gato.getFecha_nacimiento().toLocalDate());

            Raza razavalue = Raza.valueOf(gato.getRaza());

            raza.setValue(razavalue);
            sexo.setText(gato.getSexo());
        }

    }

    /**
     * Metodo para modificar los datos del gato antes mostrados con el metodo
     * buscarGato
     *
     */
    @FXML
    private void updateGato(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        DAOGato dgato = new DAOGato();
        Gato gato = new Gato();
        int idG = Integer.parseInt(IDGato.getText());
        gato.setId(idG);

        gato.setNombre(nombreGato.getText());
        gato.setFecha_nacimiento(java.sql.Date.valueOf(fecha.getValue())); // llamando a la clase java sql Date al metodo value of con el valor del datepicker
        gato.setRaza(raza.getValue().toString());
        gato.setSexo(sexo.getText());

        if (dgato.update(gato)) {
            Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);

            errorAlert.setContentText("Gatito actualizado con exito')");
            errorAlert.showAndWait();
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);

            errorAlert.setContentText("No se ha podido modificar)");
            errorAlert.showAndWait();
        };
        dgato.desconectar();
    }

}
