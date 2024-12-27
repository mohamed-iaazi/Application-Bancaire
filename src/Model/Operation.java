package Model;

import java.time.LocalDate;

public class Operation {

    private  String Type;
    private  double Montant;
    private LocalDate Date;
    private  String senter;
    private  String receiver;

    public Operation(String type, double montant, LocalDate date, String senter, String receiver) {
        Type = type;
        Montant = montant;
        Date = date;
        this.senter = senter;
        this.receiver = receiver;
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

    public void setMontant(double montant) {
        Montant = montant;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getSenter() {
        return senter;
    }

    public void setSenter(String senter) {
        this.senter = senter;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "\nOperation{" +
                "\nType= " + Type +
                "\n, Montant= " + Montant +
                "\n, Date=" + Date +
                "\n, sender=" + senter +
                "\n, receiver= " + receiver +"\n"+
                '}';
    }
}
