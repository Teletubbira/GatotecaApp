/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * Controlador encargado de la vista principal FXML Controller class
 *
 * @author Irasema
 */
public class GatotecaController implements Initializable {

    @FXML
    private MenuItem Consultar;
    @FXML
    private MenuItem darAltaGato;
    @FXML
    private MenuItem darAltaCliente;
    @FXML
    private MenuItem consultarCliente;
    @FXML
    private MenuItem adoptar;
    @FXML
    private MenuItem desadoptar;
    @FXML
    private MenuItem verTodos;
    @FXML
    private MenuItem eliminarGato;
    @FXML
    private MenuItem update;
    @FXML
    private MenuItem buscarPorAño;

    /**
     * Initializes the cont @FXML private MenuItem aboutUs; roller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    /** Metodo que abre la ventana para dar de alta un gato
     * 
     */
    @FXML
    private void abrirDarAltaGato(ActionEvent event) throws IOException {
        String fxml = "dardealtagato";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Dar de alta Gatito");
        Scene scene = new Scene(fxmlLoader.load(), 399, 689);
        stage.setScene(scene);
        stage.show();
    }
    /** Metodo que abre la ventana para buscar un gato
     * 
     */
    @FXML
    private void abrirBuscarGato(ActionEvent event) throws IOException {

        String fxml = "buscargatito";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Buscar gatito");
        Scene scene = new Scene(fxmlLoader.load(), 399, 760);
        stage.setScene(scene);
        stage.show();
    }
    /** Metodo que abre la ventana de dar de alta cliente
     * 
     */
    @FXML
    private void abrirDarAltaCliente(ActionEvent event) throws IOException {
        String fxml = "dardealtacliente";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Dar de alta cliente");
        Scene scene = new Scene(fxmlLoader.load(), 399, 450);
        stage.setScene(scene);
        stage.show();
    }
    /** Metodo que abre la ventana de buscar cliente
     * 
     */
    @FXML
    private void abrirConsultarCliente(ActionEvent event) throws IOException {
        String fxml = "buscarCliente";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Buscar cliente");
        Scene scene = new Scene(fxmlLoader.load(), 399, 750);
        stage.setScene(scene);
        stage.show();

    }
    /** Metodo que abre la ventana de adoptar
     * 
     */
    @FXML
    private void abrirAdoptar(ActionEvent event) throws IOException {
        String fxml = "adoptar";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Adoptar gatito");
        Scene scene = new Scene(fxmlLoader.load(), 399, 689);
        stage.setScene(scene);
        stage.show();
    }
    /** Metodo que abre la ventana de desadoptar
     * 
     */
    @FXML
    private void abrirDesadoptar(ActionEvent event) throws IOException {
        String fxml = "desadoptar";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Desadoptar gatito");
        Scene scene = new Scene(fxmlLoader.load(), 399, 689);
        stage.setScene(scene);
        stage.show();
    }
    /** Metodo que abre la ventana para ver la lista de todos los gatos
     * 
     */
    @FXML
    private void abrirVerTodos(ActionEvent event) throws IOException {
        String fxml = "lista";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Ver todos los gatitos");
        Scene scene = new Scene(fxmlLoader.load(), 399, 689);
        stage.setScene(scene);
        stage.show();

    }
    /** Metodo que abre la ventana de eliminar gato
     * 
     */
    @FXML
    private void abrirEliminarGato(ActionEvent event) throws IOException {
        String fxml = "eliminarGato";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Dar de baja gatito");
        Scene scene = new Scene(fxmlLoader.load(), 399, 500);
        stage.setScene(scene);
        stage.show();

    }
    /** Metodo que abre la ventana para de mofificar un gato (update)
     * 
     */
    @FXML
    private void abrirModificarGato(ActionEvent event) throws IOException {
        String fxml = "updateGatito";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Modificar gatito");
        Scene scene = new Scene(fxmlLoader.load(), 399, 550);
        stage.setScene(scene);
        stage.show();
    }
    /** Metodo que abre la ventana de buscar el numero de adopciones por año introducido
     * 
     */
    @FXML
    private void abrirBuscarPorAño(ActionEvent event) throws IOException {
        String fxml = "buscarAdopcionesPorAño";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Buscar adopciones por año");
        Scene scene = new Scene(fxmlLoader.load(), 399, 350);
        stage.setScene(scene);
        stage.show();

    }
    /** Metodo que abre la ventana about us
     * 
     */
    @FXML
    private void openAboutUs(ActionEvent event) throws IOException {
        String fxml = "aboutUs";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("About Us");
        Scene scene = new Scene(fxmlLoader.load(), 399, 350);
        stage.setScene(scene);
        stage.show();
    }

}
