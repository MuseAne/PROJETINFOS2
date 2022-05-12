package fr.insa.sth1.b7.projet_info_s2;

public class EquationDroite {

    private double Coefficient_directeur;
    private double Reste; //J'appelle reste la valeur de p quand on a : y = mx + p

    public EquationDroite(double m, double p) {
        Coefficient_directeur = m;
        Reste = p;
    }

    public double getCoefficient_directeur() {
        return Coefficient_directeur;
    }

    public double getReste() {
        return Reste;
    }

}
