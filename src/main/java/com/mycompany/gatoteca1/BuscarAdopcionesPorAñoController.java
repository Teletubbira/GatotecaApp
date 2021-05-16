/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1;

import com.mycompany.gatoteca1.dao.DAOPatronaje;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/** Controlador que muestra el numero de adopciones en el año introducido por el usuario
 * FXML Controller class
 *
 * @author Irasema
 */
public class BuscarAdopcionesPorAñoController implements Initializable {

    @FXML
    private TextField año;
    @FXML
    private Button buscar;
    @FXML
    private TextField numeroAdopciones;

    /** 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    /** Metodo que busca los gatos adoptados por año introducido
     * 
     */
    @FXML
    private void buscarPorAño(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        DAOPatronaje dpatronaje = new DAOPatronaje();
        int fecha = Integer.parseInt(año.getText());
        int adopciones = dpatronaje.buscarAdopcionesPorAño(fecha);
        dpatronaje.desconectar();
        numeroAdopciones.setText(String.valueOf(adopciones));
    }

}
