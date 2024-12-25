package Model;

public abstract  class   Compte {

    private  int Numero;
    private  double Solde;
    private  Client proprietaire;

    public Compte(int numero, double solde, Client proprietaire) {
        Numero = numero;
        Solde = solde;
        this.proprietaire = proprietaire;
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

    public Client getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Client proprietaire) {
        this.proprietaire = proprietaire;
    }
}
