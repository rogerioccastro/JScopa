package br.edu.ifsp.jscopa;

import java.io.IOException;

import javafx.fxml.FXML;

public class HowToPlay {
    
    @FXML
    private void returnToPrimary() throws IOException{

        App.setRoot("primary");

    }

}