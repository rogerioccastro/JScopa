package br.edu.ifsp.jscopa;

import java.io.IOException;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void start() throws IOException {

        Jogo jogo = new Jogo();
        jogo.testeSubset();

        App.setRoot("secondary");
    }
    @FXML
    private void howToPlayButton() throws IOException {

        App.setRoot("howtoplay");
    }
}
