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
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Controlador que gestiona la eliminacion del gato en la base de datos
 * FXML Controller class
 *
 * @author Irasema
 */
public class EliminarGatoController implements Initializable {

    @FXML
    private ListView<Gato> listaGatitos;
    @FXML
    private TextField idGato;
    @FXML
    private Button Aceptar;
    @FXML
    private Button Cancelar;

    /** Se inicializa llamando al metodo de actualizarLista
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
       actualizarLista();
        }
        catch(Exception e){
            
        }
    /** Metodo que actualiza la lista de gatos despues de que se elimine uno
     * 
     */
    }
    private void actualizarLista()throws SQLException, ClassNotFoundException, IOException{
        DAOGato dgato = new DAOGato();
        List<Gato> gatitos = dgato.getAll();
        dgato.desconectar();
        listaGatitos.getItems().setAll(FXCollections.observableList(gatitos));

    }
    /** Metodo que elimina el gato si la id introducida es valida
     * 
     */
    @FXML
    private void eliminarGato(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        DAOGato daogato = new DAOGato();

        int idG = Integer.parseInt(idGato.getText());
        boolean gatoEliminado = daogato.delete(idG);
        daogato.desconectar();

        if (gatoEliminado) {
            Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
            errorAlert.setContentText("Se ha eliminado al gato de la gatoteca");
            errorAlert.showAndWait();
            actualizarLista();
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("No se ha podido eliminar");
            errorAlert.showAndWait();
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
