package Model;

import java.time.LocalDate;

public class Operation {

    private  String Type;
    private  double Montant;
    private LocalDate Date;
    private  int CompteAssocie;

    public Operation(String type, double montant, LocalDate date, int compteAssocie) {
        Type = type;
        Montant = montant;
        Date = date;
        CompteAssocie = compteAssocie;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getMontant() {
        return Montant;
    }

    public void setMontant(int montant) {
        Montant = montant;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public int getCompteAssocie() {
        return CompteAssocie;
    }

    public void setCompteAssocie(int compteAssocie) {
        CompteAssocie = compteAssocie;
    }
}
