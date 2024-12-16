package br.edu.ifsp.jscopa;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class SecondaryController {

    @FXML
    HBox deck;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    protected void initialize()
    {
        for (Carta c : App.jogo.jogador1.getMao())
        {
            deck.getChildren().add(new ImageView(String.valueOf(App.class.getResource("cartas/" + Carta.toString(c) + ".png"))));
        }
    }
}
