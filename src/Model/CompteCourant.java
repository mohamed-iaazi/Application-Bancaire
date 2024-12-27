package Model;

import java.time.LocalDate;

public class CompteCourant extends Compte {
    private  double FraisBancaires;

    public CompteCourant(int numero, double solde, int proprietaire, LocalDate date, double fraisBancaires) {
        super(numero, solde, proprietaire,date);
        FraisBancaires = fraisBancaires;
    }
    public  CompteCourant(){

    }

    public double getFraisBancaires() {
        return FraisBancaires;
    }

    public void setFraisBancaires(double fraisBancaires) {
        FraisBancaires = fraisBancaires;
    }


}
