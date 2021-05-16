/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/** Controlador que informa sobre la informacion de contacto de la aplicacion
 * FXML Controller class
 *
 * @author Irasema
 */
public class AboutUsController implements Initializable {
    
    @FXML
    private TextArea aboutUs;

    /** Metodo que inicializa la clase con un fichero determinado y ademas que el texto no sea editable por el usuario
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            aboutUs.setEditable(false);
            File aboutUsfile = new File(App.class.getResource("aboutUs.txt").getPath());
            Scanner myReader = new Scanner(aboutUsfile);
            String data = "";
            while (myReader.hasNextLine()) {
                data = data + myReader.nextLine() + "\n";
                
            }
            
            aboutUs.setText(data);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
    
}
