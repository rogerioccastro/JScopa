package br.edu.ifsp.jscopa;

import java.util.ArrayList;

class Util {

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


}
