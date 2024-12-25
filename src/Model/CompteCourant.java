package Model;

public class CompteCourant extends Compte {
    private  double FraisBancaires;

    public CompteCourant(int numero, double solde, int proprietaire, double fraisBancaires) {
        super(numero, solde, proprietaire);
        FraisBancaires = fraisBancaires;
    }

    public double getFraisBancaires() {
        return FraisBancaires;
    }

    public void setFraisBancaires(double fraisBancaires) {
        FraisBancaires = fraisBancaires;
    }
}
