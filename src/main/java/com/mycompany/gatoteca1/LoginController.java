/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1;

import com.mycompany.gatoteca1.dao.LoginValidate;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Irasema
 */
public class LoginController implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private Button OK;

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
    private void validar(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        LoginValidate login = new LoginValidate();
        String username = user.getText();
        String passw = pass.getText();

        if (login.validate(username, passw)) {
            Stage stage = (Stage) OK.getScene().getWindow();

            stage.close();
            String fxml = "gatoteca";
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
            stage = new Stage();
            stage.setTitle("La gatoteca");
            Scene scene = new Scene(fxmlLoader.load(), 500, 400);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("El usuario y/o contraseña no son validos");
            errorAlert.showAndWait();
        }

    }

}
