package fr.insa.sth1.b7.projet_info_s2;

public class FormatDeRetourSystemNoeuds {

    private Matrice Systeme; //Ici, on a les deux équations par noeuds
    private Matrice Egalite; //Ici on a les équivalence des équations précedentes

    public FormatDeRetourSystemNoeuds(Matrice Systeme, Matrice Egalite) {
        this.Systeme = Systeme;
        this.Egalite = Egalite;
    }

    public Matrice getSysteme() {
        return Systeme;
    }

    public Matrice getEgalite() {
        return Egalite;
    }

    public String toString() {
        String res;
        res = "\nSysteme : \n" + Systeme.toString() + "\nEgalité : \n" + Egalite.toString();
        return res;
    }

}
