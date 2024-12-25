package Model;

public class CompteCourant extends Compte {
    private  int FraisBancaires;

    public CompteCourant(int numero, double solde, Client proprietaire, int fraisBancaires) {
        super(numero, solde, proprietaire);
        FraisBancaires = fraisBancaires;
    }

    public int getFraisBancaires() {
        return FraisBancaires;
    }

    public void setFraisBancaires(int fraisBancaires) {
        FraisBancaires = fraisBancaires;
    }
}
