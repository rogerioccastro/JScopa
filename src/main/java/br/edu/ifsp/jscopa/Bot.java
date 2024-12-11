package br.edu.ifsp.jscopa;

import java.util.ArrayList;

class Bot extends Jogador {

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
        
    }
}
