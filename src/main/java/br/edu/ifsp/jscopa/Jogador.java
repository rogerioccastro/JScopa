package br.edu.ifsp.jscopa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Jogador {
    private ArrayList<Carta> mao;
    private Stack<Carta> deck;

    private int qtdOuros = 0;
    private int qtdDeSetes = 0;
    private int qtdEscopas = 0;
    private boolean belo = false;
    private int[] primeira = {0,0,0,0};

    public int getQtdOuros(){ return qtdOuros; }
    public int getQtdDeSetes(){ return qtdDeSetes; }
    public int getQtdEscopas(){ return qtdEscopas; }
    public boolean getBelo(){ return belo; }

    public int getPrimeira(){ 
        int soma = 0;
        for (int i = 0; i < 4; i++){
            soma += primeira[i];
        }

        return soma; 
    }


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
        mao.removeIf(c -> Carta.toString(carta).equals(Carta.toString(c)));
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
