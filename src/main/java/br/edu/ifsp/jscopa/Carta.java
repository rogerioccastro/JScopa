package br.edu.ifsp.jscopa;

public class Carta {

    public enum Naipe {

        PAUS,
        OUROS,
        COPAS,
        ESPADAS;

        private static final Naipe[] naipes = Naipe.values();

        public static Naipe getNaipes(int i) {

            return Naipe.naipes[i];

        }
    }

    public enum Numero {

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

        public static int toInt(Numero numero) {

            switch (numero) {
                case A:
                    return 1;
                case DOIS:
                    return 2;
                case TRES:
                    return 3;
                case QUATRO:
                    return 4;
                case CINCO:
                    return 5;
                case SEIS:
                    return 6;
                case SETE:
                    return 7;
                case VALETE:
                    return 8;
                case DAMA:
                    return 9;
                case REI:
                    return 10;
                default:
                    return 0;
            }

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


    public int getInt() {
        return Numero.toInt(this.numero);
    }

    //metodo return toString
    public static String toString(Carta carta) {

        return carta.naipe + "_" + carta.numero;

    }

}
