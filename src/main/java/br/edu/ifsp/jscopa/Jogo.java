package br.edu.ifsp.jscopa;

import java.util.ArrayList;
import java.util.Arrays;

public class Jogo {

    private boolean vezDoPlayer;

    private Deck deck;
    private ArrayList<Carta> maoPlayer;

    public Jogo() {
        deck = new Deck();
        deck.embaralhar();
        vezDoPlayer = true; //faz o jogador comecar contra a máquina
        Jogador player = new Jogador(maoPlayer);

        for (int i = 0; i < 1; i++) {
            ArrayList<Carta> mao = new ArrayList<Carta>(Arrays.asList(deck.comprarCartas(3)));
            mao.forEach(carta -> {
                player.comprarCarta(carta);
            });
        }

    }

    public static void testeSubset(){
        ArrayList<Carta> teste = new ArrayList<Carta>();

        teste.add(new Carta(Carta.Naipe.COPAS, Carta.Numero.A));
        teste.add(new Carta(Carta.Naipe.COPAS, Carta.Numero.DOIS));
        teste.add(new Carta(Carta.Naipe.COPAS, Carta.Numero.TRES));
        teste.add(new Carta(Carta.Naipe.COPAS, Carta.Numero.QUATRO));
        teste.add(new Carta(Carta.Naipe.COPAS, Carta.Numero.CINCO));
        teste.add(new Carta(Carta.Naipe.COPAS, Carta.Numero.SEIS));
        teste.add(new Carta(Carta.Naipe.COPAS, Carta.Numero.SETE));
        teste.add(new Carta(Carta.Naipe.COPAS, Carta.Numero.VALETE));
        teste.add(new Carta(Carta.Naipe.COPAS, Carta.Numero.DAMA));
        teste.add(new Carta(Carta.Naipe.COPAS, Carta.Numero.REI));

        ArrayList<ArrayList<Carta>> result = subsetSum(teste, 15, new ArrayList<Carta>());

        result.forEach(subset -> {
            subset.forEach(carta -> {
                System.out.print(Carta.toString(carta) + " ");
            });
            System.out.println();
        });
    }

    public void start(Jogo jogo) {
        /* TODO:
         * Modulo do jogo em si.
         * 
         * 
         */
    }

    // lista todas as possíveis jogadas que somam 15 com a carta selecionada
    public void listarPossiveisJogadas(Carta cartaSelecionada) {
        //TODO: algoritimo para listar todas as somas de 15 com a carta selecionada
    }


    // retorna todas as combinações possíveis de cartas que somam o inteiro passado
    private static ArrayList<ArrayList<Carta>> subsetSum(ArrayList<Carta> arr, int sum, ArrayList<Carta> subset) {

        // transforma o array de cartas em um array de inteiros e soma
        int s = subset.stream().mapToInt(Carta::getInt).sum();
        ArrayList<ArrayList<Carta>> result = new ArrayList<ArrayList<Carta>>();

        // adicionar ao resultado se a soma for igual ao valor passado
        if (s == sum) {
            result.add(subset);
        }

        // se a soma for maior que o valor passado, não tem necessidade de checar mais
        if (s > sum) {
            return result;
        }

        for (int i = 0; i < arr.size(); i++) {
            Carta n = arr.get(i);
            ArrayList<Carta> remaining = new ArrayList<Carta>();
            for (int j = i + 1; j < arr.size(); j++) {
                remaining.add(arr.get(j));
            }
            ArrayList<Carta> subset_n = new ArrayList<Carta>(subset);
            subset_n.add(n);
            result.addAll(subsetSum(remaining, sum, subset_n));
        }

        return result;
    }

}
