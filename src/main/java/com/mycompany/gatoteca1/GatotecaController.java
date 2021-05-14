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
 * FXML Controller class
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
    private void abrirDarAltaGato(ActionEvent event) throws IOException {
        String fxml = "dardealtagato";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Dar de alta Gatito");
        Scene scene = new Scene(fxmlLoader.load(), 399, 689);
        stage.setScene(scene);
        stage.show();
    }

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

    @FXML
    private void abrirConsultarCliente(ActionEvent event) throws IOException{
        String fxml = "buscarCliente";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Buscar cliente");
        Scene scene = new Scene(fxmlLoader.load(), 399, 750);
        stage.setScene(scene);
        stage.show();
        
    }

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

    @FXML
    private void abrirVerTodos(ActionEvent event) throws IOException{
        String fxml = "lista";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setTitle("Ver todos los gatitos");
        Scene scene = new Scene(fxmlLoader.load(), 399, 689);
        stage.setScene(scene);    
        stage.show();
        
    }

}
