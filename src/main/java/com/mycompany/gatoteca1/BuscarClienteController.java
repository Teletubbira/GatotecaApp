/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1;

import com.mycompany.gatoteca1.dao.DAOCliente;
import com.mycompany.gatoteca1.modelos.Cliente;
import com.mycompany.gatoteca1.modelos.Gato;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Controlador para buscar clientes en la base de datos
 * FXML Controller class
 *
 * @author Irasema
 */
public class BuscarClienteController implements Initializable {

    @FXML
    private Button Aceptar;
    @FXML
    private Button Cancelar;
    @FXML
    private TextField IDCliente;
    @FXML
    private TextField NombreCliente;
    @FXML
    private TextField PrimerApellido;
    @FXML
    private TextField SegundoApellido;

    @FXML
    private ListView<Gato> ListaGatitos;

    /** Se inicializa la ventana sin poder editar los campos por el usuario
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NombreCliente.setEditable(false);
        PrimerApellido.setEditable(false);
        SegundoApellido.setEditable(false);

    }
    /** Metodo que cierra la ventana actual
     * 
     */
    @FXML
    private void closeWindow(MouseEvent event) {
        Stage stage = (Stage) Cancelar.getScene().getWindow();
        stage.close();
    }
    /** Metodo que muestra los datos del cliente a partid del id introducido
     * 
     */
    @FXML
    private void buscarCliente(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {

        DAOCliente dcliente = new DAOCliente();
        int id = Integer.parseInt(IDCliente.getText());
        Cliente cliente = dcliente.get(id);
        

        NombreCliente.setText(cliente.getNombre());
        PrimerApellido.setText(cliente.getApellido_p());
        SegundoApellido.setText(cliente.getApellido_s());
        
        List<Gato> gatitos = dcliente.getGatitosAdoptados(id); // para ver los gatos que ese cliente haya adoptado
        dcliente.desconectar();
        ListaGatitos.getItems().setAll(FXCollections.observableList(gatitos));
        
    }

}
