package fr.insa.sth1.b7.projet_info_s2;

import java.util.ArrayList;

public class TypeBarre {

    private int Id;
    private String Section;
    private double Lmin;
    private double Lmax;
    private double RmC;
    private double RmT;
    private String Materiaux;
    private ArrayList<Barre> Barre_TypeBarre;

    public TypeBarre(int Iden) { //On s'en fout de ce qu'il y a dedans c'est juste pour dire qu'il y a un truc quoi
        Id = Iden;
        Section = "Rond";
        Lmin = 3;
        Lmax = 4;
        RmC = -100;
        RmT = 50;
        Materiaux = "Fer";
        Barre_TypeBarre = new ArrayList<>();
    }

    public TypeBarre(int Iden, String S, double C, double ResiMC, double ResiMT, String Mat) { //On s'en fout de ce qu'il y a dedans c'est juste pour dire qu'il y a un truc quoi
        Id = Iden;
        Section = S;
        RmC = ResiMC;
        RmT = ResiMT;
        Materiaux = Mat;
        Barre_TypeBarre = new ArrayList<>();
    }

    public TypeBarre(int Iden, String S, double C, double ResiMC, double ResiMT, String Mat, double Cout_Sup) { //On s'en fout de ce qu'il y a dedans c'est juste pour dire qu'il y a un truc quoi
        Id = Iden;
        Section = S;
        RmC = ResiMC;
        RmT = ResiMT;
        Materiaux = Mat;
        Barre_TypeBarre = new ArrayList<>();
    }

    public String getSection() {
        return Section;
    }

    public double getLmin() {
        return Lmin;
    }

    public double getLmax() {
        return Lmax;
    }

    public double getRmC() {
        return RmC;
    }

    public double getRmT() {
        return RmT;
    }

    public String getMateriaux() {
        return Materiaux;
    }

    public ArrayList<Barre> getBarre_TypeBarre() {
        return Barre_TypeBarre;
    }

    public void addBarre_TypeBarre(Barre B) {
        Barre_TypeBarre.add(B);
    }

    public String toString() {
        String res;
        res = "\n --Type Barre " + getId() + "--" + "\n- Section : " + Section + "\n- Longueur min : " + Lmin + "\n- Longueur max : " + Lmax + "\n- Resistance à la compression : " + RmC
                + "\n- Resistance à la torsion : " + RmT + "\n- Materiau : " + Materiaux;
        res = res + "\nLes barres suivantes sont de ce type : ";

        return res;
    }

    public int getId() {
        return Id;
    }

    public String Enregistrement() {
        String S;
        S = "TypeBarre ; " + this.getId() + " ; " + this.getSection() + " ; " + this.getRmC() + " ; " + this.getRmT() + " ; " + this.getMateriaux() + "\n";
        return S;
    }
}
