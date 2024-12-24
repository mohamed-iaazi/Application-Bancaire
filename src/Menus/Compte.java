package Menus;

abstract  class   Compte {

    private  int Numero;
    private  int Solde;
    private  Client proprietaire;

    public Compte(int numero, int solde, Client proprietaire) {
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

    public int getSolde() {
        return Solde;
    }

    public void setSolde(int solde) {
        Solde = solde;
    }

    public Client getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Client proprietaire) {
        this.proprietaire = proprietaire;
    }
}
