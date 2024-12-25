package Model;

public class CompteEpargne  extends Compte{

    private  int tauxInteret;

    public CompteEpargne(int numero, double solde, Client proprietaire, int tauxInteret) {
        super(numero, solde, proprietaire);
        this.tauxInteret = tauxInteret;
    }

    public int getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(int tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
