package br.edu.ifsp.jscopa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Jogador {
    private ArrayList<Carta> mao;
    private Stack<Carta> deck;

    private int qtdOuros;
    private int qtdDeSetes;
    private int qtdEscopas;
    private boolean belo;
    private int[] primeira;

    Jogador(ArrayList<Carta> mao) {
        this.mao = mao;
    }

    Jogador() {
        this.mao = new ArrayList<Carta>();
        this.deck = new Stack<Carta>();
    }

    public ArrayList<Carta> getMao() {
        return mao;
    }

    public void setMao(ArrayList<Carta> mao) {
        this.mao = mao;
    }

    public void jogarCarta(Carta carta) {
        mao.remove(carta);
    }

    public void adicionarNoDeck(ArrayList<Carta> cartas, boolean escopa) {

        int s = cartas.stream().mapToInt(Carta::getInt).sum();

        if (s == 15) {
            cartas.forEach( carta -> {
                if (carta.getNaipe() == Carta.Naipe.OUROS){
                    this.qtdOuros++;
                }

                if (carta.getNumero() == Carta.Numero.SETE) {
                    this.qtdDeSetes++;
                }

                if (carta.getNaipe() == Carta.Naipe.OUROS && carta.getNumero() == Carta.Numero.SETE) {
                    this.belo = true;
                }
                
                if (carta.getInt() < 8){
                    int idx = carta.getNaipe().ordinal();
                    if (primeira[idx] < carta.getInt()){
                        primeira[idx] = carta.getInt();
                    }
                }

                if (escopa) {
                    qtdEscopas++;
                }

                deck.push(carta);
            });
        }

    }

    public void comprarCarta(Carta carta) {
        mao.add(carta);
    }
}
