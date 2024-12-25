package Model;

public class CompteEpargne  extends Compte{

    private  double tauxInteret;

    public CompteEpargne(int numero, double solde, Client proprietaire, double tauxInteret) {
        super(numero, solde, proprietaire);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
