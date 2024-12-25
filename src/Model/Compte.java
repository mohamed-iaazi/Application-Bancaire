package Model;

public abstract  class   Compte {

    private  int Numero;
    private  double Solde;
    private  int proprietaire;

    public Compte(int numero, double solde, int proprietaire) {
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

    public int getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(int proprietaire) {
        this.proprietaire = proprietaire;
    }
}
