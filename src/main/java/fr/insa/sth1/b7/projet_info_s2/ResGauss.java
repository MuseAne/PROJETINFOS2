package fr.insa.sth1.b7.projet_info_s2;

public class ResGauss {

    public int rang;

    public int signature;

    public ResGauss() {

        this.rang = 0;

        this.signature = 0;
    }

    public ResGauss(int rang, int signature) {

        this.rang = rang;

        this.signature = signature;
    }

    public String toString() {

        String res = "Le rang de la descente de la matrice est : " + this.rang + "\nLa signature de la descente de la matrice est : " + this.signature;

        return res;
    }

}
