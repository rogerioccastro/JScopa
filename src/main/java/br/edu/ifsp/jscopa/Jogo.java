package br.edu.ifsp.jscopa;
import java.util.ArrayList;
import java.util.Arrays;

public class Jogo {
    private boolean vezDoPlayer;

    private Deck deck;
    private ArrayList<ArrayList<Carta>> maoPlayer;
    private ArrayList<Carta> stockpile;

    public Jogo(){
        deck = new Deck();
        deck.embaralhar();
        stockpile = new ArrayList<Carta>();

        vezDoPlayer = true; //faz o jogador comecar contra a máquina

        maoPlayer = new ArrayList<ArrayList<Carta>>();

        for(int i = 0; i < 1; i++){
            ArrayList<Carta> mao = new ArrayList<Carta>(Arrays.asList(deck.comprarCartas(3)));
            maoPlayer.add(mao);
        }
    } 

    public void start(Jogo jogo){

    }

}
