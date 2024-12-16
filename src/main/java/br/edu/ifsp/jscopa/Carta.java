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
        DAMA,
        VALETE,
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
                case DAMA:
                    return 8;
                case VALETE:
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
    public boolean escopa;

    public Carta(final Naipe naipe, final Numero numero) {

        this.naipe = naipe;
        this.numero = numero;

    }

    public Carta(final String carta) {
        String[] split = carta.split("_");

        switch(split[0]) {
            case "COPAS":
                this.naipe = Naipe.COPAS;
                break;

            case "PAUS":
                this.naipe = Naipe.PAUS;
                break;

            case "OUROS":
                this.naipe = Naipe.OUROS;
                break;

            case "ESPADAS":
                this.naipe = Naipe.ESPADAS;
                break;

            default:
                this.naipe = Naipe.COPAS;
                break;
        }

        switch (split[1]) {
            case "A":
                this.numero = Numero.A;
                break;
            case "DOIS":
                this.numero = Numero.DOIS;
                break;
            case "TRES":
                this.numero = Numero.TRES;
                break;
            case "QUATRO":
                this.numero = Numero.QUATRO;
                break;
            case "CINCO":
                this.numero = Numero.CINCO;
                break;
            case "SEIS":
                this.numero = Numero.SEIS;
                break;
            case "SETE":
                this.numero = Numero.SETE;
                break;
            case "DAMA":
                this.numero = Numero.DAMA;
                break;
            case "VALETE":
                this.numero = Numero.VALETE;
                break;
            case "REI":
                this.numero = Numero.REI;
                break;
            default:
                this.numero = Numero.REI;
                break;
        }


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
