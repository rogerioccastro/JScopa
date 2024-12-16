package br.edu.ifsp.jscopa;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;

public class SecondaryController {

    @FXML
    HBox deck;

    @FXML
    HBox mesa;

    @FXML
    HBox bot;

    @FXML VBox vbox;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    private void draw() {
        App.jogo.jogador2.getMao().forEach( carta -> {

            ImageView imageView = new ImageView(String.valueOf(App.class.getResource("cartas/card-back1.png")));
            if (!bot.getChildren().contains(imageView)){
                bot.getChildren().add(imageView);
            }
        });

        for (Carta c : App.jogo.getMesa())
        {

            ImageView imageView = new ImageView(String.valueOf(App.class.getResource("cartas/" + Carta.toString(c) + ".png")));
            if (!mesa.getChildren().contains(imageView));
            mesa.getChildren().add(imageView);
        }

        for (Carta c : App.jogo.jogador1.getMao())
        {
            ImageView imageView = new ImageView(String.valueOf(App.class.getResource("cartas/" + Carta.toString(c) + ".png")));
            imageView.setOnMouseClicked(event -> {
                String url = (imageView.getImage().getUrl());
                String nome = url.substring(url.lastIndexOf("/") + 1).replace(".png", ""); 
                ArrayList<ArrayList<Carta>> possiveisJogadas = new ArrayList<>();

                Carta cartaSelecionada = new Carta(nome);
                possiveisJogadas = App.jogo.listarPossiveisJogadas(cartaSelecionada);

                if (possiveisJogadas.size() != 0) {
                    // TODO: jogar
                } else {
                    App.jogo.adicionarAMesa(cartaSelecionada);
                }
                draw();
            });
            if (!mesa.getChildren().contains(imageView));
            mesa.getChildren().add(imageView);
        }
    }

    @FXML
    protected void initialize()
    {

        
        VBox.setVgrow(mesa, Priority.ALWAYS);

        vbox.setScaleShape(true);

        draw();

        deck.getChildren().forEach(carta -> {
        });

    }
}
