/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1;

import com.mycompany.gatoteca1.dao.DAOGato;
import com.mycompany.gatoteca1.modelos.Gato;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * Controlador que muestra la lista total de gatos FXML Controller class
 *
 * @author Irasema
 */
public class ListaController implements Initializable {

    @FXML
    private ListView<Gato> list;

    /**
     * Metodo que inicializa la ventana con la lista de los gatos Initializes
     * the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            DAOGato dgato = new DAOGato();
            List<Gato> gatitos = dgato.getAll();
            dgato.desconectar();
            list.getItems().setAll(FXCollections.observableList(gatitos));

        } catch (Exception e) {

        }

    }

}
