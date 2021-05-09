package com.mycompany.gatoteca1;

import com.controllers.*;
import com.mycompany.gatoteca1.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
