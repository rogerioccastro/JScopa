package br.edu.ifsp.jscopa;

import java.util.ArrayList;
import java.util.Arrays;

public class Jogo {

    private boolean vezDoPlayer;

    public static Deck deck;
    Jogador jogador1;
    Bot jogador2;

    private int pontos1;
    private int pontos2;

    public ArrayList<Carta> mesa;

    public Jogo() {
        deck = new Deck();
        deck.reset();
        deck.embaralhar();
        vezDoPlayer = true; // faz o jogador comecar contra a máquina
        this.jogador1 = new Jogador();
        this.jogador2 = new Bot();

        mesa = new ArrayList<Carta>();


        this.mesa = new ArrayList<Carta>(Arrays.asList(deck.comprarCartas(4)));
        mesa.forEach(carta -> {
            System.out.print(Carta.toString(carta) + " ");
        });
        tirarCartas();
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

        return Util.subsetSum(mesa, 15 - n, new ArrayList<Carta>());
    }

    public void start(Jogo jogo) {
        while(true) {
            if (!vezDoPlayer) {
                jogador2.jogar();
            }
        }
    }

    public void computarPontos() {
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
            pontos1 =+ 4;
        }

        if(jogador2.getQtdDeSetes() == 4) {
            pontos2 =+ 4;
        }

        this.pontos1 = pontos1;
        this.pontos2 = pontos2;

        System.out.println(pontos1);
        System.out.println(pontos2);
    }

    public void jogar(Carta cartaSelecionada, ArrayList<Carta> cartasDaMesa, Jogador jogador){

        if (cartasDaMesa.size() == 0) {
            adicionarAMesa(cartaSelecionada);
            jogador.jogarCarta(cartaSelecionada);

            jogador.getMao().forEach(c -> {
                System.out.println(Carta.toString(c));
            });
            return;
        } 

        cartasDaMesa.add(cartaSelecionada);
        jogador.adicionarNoDeck(cartasDaMesa, false);
        cartasDaMesa.forEach(c -> {
            mesa.removeIf(ca -> Carta.toString(ca).equals(Carta.toString(c)));
        });
        jogador.jogarCarta(cartaSelecionada);
    }

    public void tirarCartas(){
        if (deck.getQtdCartas() == 0){
            computarPontos();
            return;
        }

        ArrayList<Carta> mao1 = new ArrayList<Carta>(Arrays.asList(deck.comprarCartas(3)));
        ArrayList<Carta> mao2 = new ArrayList<Carta>(Arrays.asList(deck.comprarCartas(3)));
        mao1.forEach(carta -> {
            jogador1.comprarCarta(carta);
        });

        mao2.forEach(carta -> {
            jogador2.comprarCarta(carta);
        });
    }

    ArrayList<Carta> getMesa(){
        return this.mesa;
    }

    public int updatePontosPlayer1(){

        return this.pontos1;

    }

    public void adicionarAMesa (Carta carta){
        this.mesa.add(carta);
    }
}
