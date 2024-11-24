package br.edu.ifsp.jscopa;

import java.util.Random;

public class Deck {

    private Carta[] cartas;
    private int qtdCartasDeck;

    public Deck() {

        cartas = new Carta[108];

    }

    // metodo inicializador do deck
    public void reset() {

        Carta.Naipe[] naipes = Carta.Naipe.values();
        qtdCartasDeck = 0;

        // adiciona todas as cartas (de todos os valores (1 a 10) e naipes) no deck  
        for (int i = 0; i < naipes.length - 1; i++) {

            Carta.Naipe naipe = naipes[i];

            cartas[qtdCartasDeck++] = new Carta(naipe, Carta.Numero.getNumero(0));

            for (int j = 1; j < 10; j++) {

                cartas[qtdCartasDeck++] = new Carta(naipe, Carta.Numero.getNumero(j));
                cartas[qtdCartasDeck++] = new Carta(naipe, Carta.Numero.getNumero(j));

            }

        }

    }

    public boolean estaVazio() {
        return qtdCartasDeck == 0;
    }

    public void embaralhar() {

        int n = cartas.length;

        Random aleatorio = new Random();

        for (int i = 0; i < cartas.length; i++) {

            //pegar um index aleatorio do array ALÉM do index atual
            //trocar o elemento aleatorio pelo elemento atual
            int valorAleatorio = i + aleatorio.nextInt(n - 1);
            Carta cartaAleatoria = cartas[valorAleatorio];
            cartas[valorAleatorio] = cartas[i];
            cartas[i] = cartaAleatoria;

        }

    }

}
