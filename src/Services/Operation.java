package Services;

import Model.CompteCourant;
import Utils.Input;

import static Utils.Colors.*;

public class Operation {

    public static void Virment() {
        boolean error=false;
        System.out.print("   Entrez l Nome client pour l'expéditeur : ");
        String senderNome= Input.GetInput();
        System.out.print("   Entrez l Nome client pour le destinataire : ");
        String receiverNome= Input.GetInput();
        if (Input.ClientIsAvailable(senderNome)>=0 && Input.ClientIsAvailable(receiverNome)>=0){
            System.out.print("   Entrez le montant  : ");
            do {
                try {
                    int montant = Integer.parseInt(Input.GetInput());
                    if (montant<=0){
                        error=true;
                        System.out.println(Red+"   Montant Non Valide  "+Reset);
                    }
                    else {

                        if (DecreaseVairmentMontant(montant,Input.ClientIsAvailable(senderNome))) {
                            AddVairmentMontant(montant, Input.ClientIsAvailable(receiverNome));
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println(Red+"   Montant Non Valide  "+Reset);
                    error=true;
                }
            }while (error);
        }
        else {

        }
    }

    private static void AddVairmentMontant(int montant,int Id) {
        CompteCourant compteCourant=Compte.getcompteCourantList().get(Id);
        compteCourant.setSolde(compteCourant.getSolde()+montant);
        System.out.print(Green + "\n  Votre Vairment a été effectué avec succès " + Reset);
    }

    private static boolean DecreaseVairmentMontant(int montant,int Id) {
        CompteCourant compteCourant=Compte.getcompteCourantList().get(Id);

        if (compteCourant.getSolde()-montant>=0) {
            compteCourant.setSolde(compteCourant.getSolde() - montant);
            System.out.print(Green + "\n  Votre Vairment a été effectué avec succès " + Reset);
            return true;
        }
        else {
            System.out.print(Red + "\n  Votre solde est insuffisant " + Reset);
            return  false;
        }
    }

    public static  void Retrait() {
    }

    public static void Depots() {
    }
}
