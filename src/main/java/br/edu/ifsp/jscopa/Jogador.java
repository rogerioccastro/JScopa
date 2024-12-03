package br.edu.ifsp.jscopa;

import java.io.IOException;
import java.util.ArrayList;

public class Jogador {
    private ArrayList<Carta> mao;

    Jogador(ArrayList<Carta> mao) {
        this.mao = mao;
    }

    Jogador() {
        this.mao = new ArrayList<Carta>();
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

    public void comprarCarta(Carta carta) {
        mao.add(carta);
    }

    // lista todas as possíveis jogadas que somam 15 com a carta selecionada
    public ArrayList<ArrayList<Carta>> listarPossiveisJogadas(Carta cartaSelecionada) {
        int n = cartaSelecionada.getInt();
    }

}
