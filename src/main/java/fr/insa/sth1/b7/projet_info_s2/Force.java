package fr.insa.sth1.b7.projet_info_s2;

public class Force {

    private double Norme;
    private double Angle;
    private int Id;

    public Force(double N, double A, int Id) {
        Norme = N;
        Angle = A;
        this.Id = Id;
    }

    public Force(double N, double A) {
        this(N, A, 0);
    }

    public Force() {
        this(0, -Math.PI / 2, 0);
    }

    public double getNorme() {
        return Norme;
    }

    public double getAngle() {
        return Angle;
    }

    public int getId() {
        return Id;
    }

    public String Enregistrement() {
        String S;
        S = "Force ; " + this.getId() + " ; " + this.getNorme() + " ; " + this.getAngle() + "\n";
        return S;
    }

}
