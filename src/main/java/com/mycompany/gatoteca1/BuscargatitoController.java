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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Controlador para buscar gatos en la base de datos
 * FXML Controller class
 *
 * @author Irasema
 */
public class BuscargatitoController implements Initializable {

    @FXML
    private TextField IDGato;
    @FXML
    private TextField NombreGatito;
    @FXML
    private DatePicker Fecha;
    @FXML
    private TextField Raza;
    @FXML
    private TextField Sexo;
    @FXML
    private Button Aceptar;
    @FXML
    private Button Cancelar;
    @FXML
    private TextField NombreDelGato;

    /** Metodo que inicializa la ventana sin que el usuario pueda modificar los campos
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        NombreGatito.setEditable(false);
        Fecha.setEditable(false);
        Raza.setEditable(false);
        Sexo.setEditable(false);
    }
    /** Metodo que busca al gato por su nombre o por su id
     * 
     */
    @FXML
    private void buscargatito(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        DAOGato daogato = new DAOGato();
        
        String nombre = NombreDelGato.getText();      // buscar por nombre

        if (nombre.length() > 1 ) {  // si nombre es distinto de null
            System.out.println("Buscando por nombre: " +nombre);
            IDGato.setText("");
            Gato gato = daogato.buscarPorNombre(nombre);
            daogato.desconectar();
            if (gato != null) { //Comprobamos si el gato existe en bbdd
                IDGato.setText(String.valueOf(gato.getId()));
                NombreGatito.setText(gato.getNombre());
                Fecha.setValue(gato.getFecha_nacimiento().toLocalDate());
                Raza.setText(gato.getRaza());
                Sexo.setText(gato.getSexo());
            } else {  //En caso de que no exista mostramos error
                NombreGatito.setText("");
                Fecha.setValue(null);
                Raza.setText("");
                Sexo.setText("");
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("No tenemos al gatito que buscas :(");
                errorAlert.setContentText("Pero tenemos muchos otros :')");
                errorAlert.showAndWait();
            }

        } else {
            
            int id = Integer.parseInt(IDGato.getText());  // buscar por ID
            System.out.println("Buscando por id: " +id);
            Gato gato = daogato.get(id);
            daogato.desconectar();
            if (gato != null) { //Comprobamos si el gato existe en bbdd

                NombreGatito.setText(gato.getNombre());
                Fecha.setValue(gato.getFecha_nacimiento().toLocalDate());
                Raza.setText(gato.getRaza());
                Sexo.setText(gato.getSexo());
            } else {  //En caso de que no exista mostramos error
                NombreGatito.setText("");
                Fecha.setValue(null);
                Raza.setText("");
                Sexo.setText("");
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("No tenemos al gatito que buscas :(");
                errorAlert.setContentText("Pero tenemos muchos otros :')");
                errorAlert.showAndWait();
            }

        }

    }
    /** Metodo que cierra la ventana actual
     * 
     */
    @FXML
    private void closeWindow(MouseEvent event) {
        Stage stage = (Stage) Cancelar.getScene().getWindow();

        stage.close();
    }

}
