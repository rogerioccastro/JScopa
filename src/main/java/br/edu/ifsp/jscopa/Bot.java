package br.edu.ifsp.jscopa;

import java.util.ArrayList;

import br.edu.ifsp.jscopa.Carta.Naipe;
import br.edu.ifsp.jscopa.Carta.Numero;

class Bot extends Jogador {
    private double melhorScore = 0;

    static int minimax(int currdepth, boolean isMax,
            int scores[], int currnodeIndex, int h)
    {

        if (currdepth == h)
            return scores[currnodeIndex];


        if (isMax)
            return Math.max(minimax(currdepth+1, false, scores, currnodeIndex*2, h),
                    minimax(currdepth+1, false, scores, currnodeIndex*2 + 1, h));


        else
            return Math.min(minimax(currdepth+1, true, scores, currnodeIndex*2, h),
                    minimax(currdepth+1, true, scores, currnodeIndex*2 + 1, h));
    }

    void jogar(ArrayList<Carta> mesa){
        ArrayList<ArrayList<Carta>> possibilidades = new ArrayList<ArrayList<Carta>>();

        getMao().forEach(carta -> {
            int n = carta.getInt();

            Util.subsetSum(mesa, 15-n, new ArrayList<Carta>()).forEach(subset -> {
                subset.add(carta);
                possibilidades.add(subset);
            });


        });

        possibilidades.forEach(possibilidade -> {
            ArrayList<Carta> mesaFutura = new ArrayList<Carta>();

            mesaFutura.addAll(mesa);

            mesaFutura.removeAll(possibilidade);

            if (Jogo.deck.getQtdCartas() < 10){
                //TODO: CRIAR SCORES
            } else {
                int qtdDeOuros = 0;
                int qtdDeCartas = 0;
                int soma = 0;
                int belo = 0;
                int escopa = 0;

                qtdDeOuros = (int)mesaFutura.stream().filter(carta -> 
                        { return carta.getNaipe() == Naipe.OUROS; }).count();

                qtdDeCartas = mesaFutura.size();

                soma  = mesaFutura.stream().mapToInt(Carta::getInt).sum();
                
                if(possibilidade.contains(new Carta(Naipe.OUROS, Numero.SETE))) {
                    belo = 1;
                };

                if(mesaFutura.size() == 0){
                    escopa = 1;
                };

                double score = (qtdDeOuros * -1) 
                        + (qtdDeCartas * -0.5) 
                        + ((soma - 4)* -2) 
                        + possibilidade.size()
                        + belo * 10
                        + escopa * 10;

                if (melhorScore < score) {
                    melhorScore = score;
                }
            }});
        
    }
}
