package Model;

import java.time.LocalDate;

public abstract  class   Compte {

    private  int Numero;
    private  double Solde;
    private  int proprietaire;
    private LocalDate date;

    public Compte(int numero, double solde, int proprietaire, LocalDate date) {
        Numero = numero;
        Solde = solde;
        this.proprietaire = proprietaire;
        this.date=date;
    }
    
    public  Compte(){

    }
     public String getCompte(){
        return   Blue+"\n Numero : "+Reset+ Numero
                +Blue+"\n Solde "+ Reset+Solde
                +Blue+"\n proprietaire "+Reset+ proprietaire
                +Blue+"\n date "+ Reset+date
                ;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public double getSolde() {
        return Solde;
    }

    public void setSolde(double solde) {
        Solde = solde;
    }

    public int getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(int proprietaire) {
        this.proprietaire = proprietaire;
    }
}
