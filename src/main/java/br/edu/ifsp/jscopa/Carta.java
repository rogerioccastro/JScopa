package br.edu.ifsp.jscopa;

public class Carta {

    enum Naipe {

        PAUS,
        OUROS,
        COPAS,
        ESPADAS;

        private static final Naipe[] naipes = Naipe.values();

        public static Naipe getNaipes(int i) {

            return Naipe.naipes[i];

        }
    }

    enum Numero {

        A,
        DOIS,
        TRES,
        QUATRO,
        CINCO,
        SEIS,
        SETE,
        VALETE,
        DAMA,
        REI;

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
    public static String toString(Carta carta) {

        return carta.naipe + "_" + carta.numero;

    }

}
