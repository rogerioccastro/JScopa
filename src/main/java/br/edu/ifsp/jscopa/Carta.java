package br.edu.ifsp.jscopa;

public class Carta {

    enum Naipe {

        Paus, Ouros, Copas, Espadas;

        private static final Naipe[] naipes = Naipe.values();

        public static Naipe getNaipes(int i) {

            return Naipe.naipes[i];

        }
    }

    enum Numero {

        A, Dois, Tres, Quatro, Cinco, Seis, Sete, Valete, Dama, Rei;

        private static final Numero[] numeros = Numero.values();

        public static Numero getNumero(int i) {

            return Numero.numeros[i];

        }
    }

    private final Naipe naipe;
    private final Numero numero;

    public Carta(final Naipe naipe, final Numero numero) {

        this.naipe = naipe;
        this.numero = numero;

    }

    //metodos getters
    public Naipe getNaipe() {

        return this.naipe;

    }

    public Numero getNumero() {

        return this.numero;

    }

    //metodo return toString
    public String toString() {

        return naipe + "_" + numero;

    }

}
