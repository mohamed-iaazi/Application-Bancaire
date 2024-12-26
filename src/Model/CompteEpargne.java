package Model;

import java.time.LocalDate;

public class CompteEpargne  extends Compte{

    private  double tauxInteret;

    public CompteEpargne(int numero, double solde, int proprietaire, LocalDate date, double tauxInteret) {
        super(numero, solde, proprietaire,date);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
