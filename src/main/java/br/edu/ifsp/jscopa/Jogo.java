package br.edu.ifsp.jscopa;

import java.util.ArrayList;
import java.util.Arrays;

public class Jogo {

    private boolean vezDoPlayer;

    private Deck deck;
    private Jogador jogador1;
    private Jogador jogador2;

    private int pontos1;
    private int pontos2;

    public ArrayList<Carta> mesa;

    public Jogo() {
        deck = new Deck();
        deck.reset();
        deck.embaralhar();
        vezDoPlayer = true; // faz o jogador comecar contra a máquina
        this.jogador1 = new Jogador();
        this.jogador2 = new Jogador();

        mesa = new ArrayList<Carta>();

        ArrayList<Carta> mao1 = new ArrayList<Carta>(Arrays.asList(deck.comprarCartas(3)));
        ArrayList<Carta> mao2 = new ArrayList<Carta>(Arrays.asList(deck.comprarCartas(3)));
        this.mesa = new ArrayList<Carta>(Arrays.asList(deck.comprarCartas(3)));
        mao1.forEach(carta -> {
            jogador1.comprarCarta(carta);
        });

        mesa.forEach(carta -> {
            System.out.print(Carta.toString(carta) + " ");
        });

    }

    public void testeSubset() {
        Carta cartaSelecionada = jogador1.getMao().get(0);

        ArrayList<ArrayList<Carta>> result = listarPossiveisJogadas(cartaSelecionada);

        System.out.println("\n");
        System.out.println("Somas de 15 com: " + Carta.toString(cartaSelecionada));
        result.forEach(subset -> {
            subset.forEach(carta -> {
                System.out.print(Carta.toString(carta) + " ");
            });
            System.out.println("");
        });
    }

    // lista todas as possíveis jogadas que somam 15 com a carta selecionada
    public ArrayList<ArrayList<Carta>> listarPossiveisJogadas(Carta cartaSelecionada) {
        int n = cartaSelecionada.getInt();

        return subsetSum(mesa, 15 - n, new ArrayList<Carta>());
    }

    public void start(Jogo jogo) {
        /*
         * TODO:
         * Modulo do jogo em si.
         * 
         * 
         */
    }

    // retorna todas as combinações possíveis de cartas que somam o inteiro passado
    public static ArrayList<ArrayList<Carta>> subsetSum(ArrayList<Carta> arr, int sum, ArrayList<Carta> subset) {

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

    private void computarPontos(Jogador jogador1, Jogador jogador2) {
        int pontos1 = 0;
        int pontos2 = 0;


        // 1 ponto para o belo
        if (jogador1.getBelo()) {
            pontos1++;
        } else {
            pontos2++;
        }

        // 1 ponto para cada escopa
        pontos1 += jogador1.getQtdEscopas();
        pontos2 += jogador2.getQtdEscopas();

        if(jogador1.getQtdOuros() > jogador2.getQtdOuros()){
            pontos1++;
        } else {
            pontos2++;
        }

        if(jogador1.getPrimeira() > jogador2.getPrimeira()){
            pontos1++;
        } else {
            pontos2++;
        }

        if(jogador1.getQtdDeSetes() == 4) {

        }

        this.pontos1 = pontos1;
        this.pontos2 = pontos2;
    }

}
