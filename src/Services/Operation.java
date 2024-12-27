package Services;

import Model.CompteCourant;
import Utils.Input;

import java.util.ArrayList;

import static Utils.Colors.*;

public class Operation {

   private static ArrayList<Model.Operation> operations=new ArrayList<>();

    public static void FaitVairment() {
            boolean error = false;
            System.out.print("   Entrez l Nome client pour l'expéditeur : ");
            String senderNome = Input.GetInput();
            System.out.print("   Entrez l Nome client pour le destinataire : ");
            String receiverNome = Input.GetInput();
            if (Input.ClientIsAvailable(senderNome) >= 0 && Input.ClientIsAvailable(receiverNome) >= 0) {

                if (Input.AccountIsAvailable(senderNome)<0|| Input.AccountIsAvailable(receiverNome)<0)
                {
                    System.out.print(Red+"\n\n   Aucun Compte associé à ce nom "+Reset);
                    return;
                }
                System.out.print("   Entrez le montant  : ");
                do {
                    try {
                        double montant = Integer.parseInt(Input.GetInput());
                        if (montant <= 0) {
                            error = true;
                            System.out.println(Red + "   Montant Non Valide  " + Reset);
                        } else {

                            if (DecreaseVairmentMontant((int) montant, Input.ClientIsAvailable(senderNome))) {
                                AddVairmentMontant((int) montant, Input.ClientIsAvailable(receiverNome));
                               operations.add(new Model.Operation("Vairement ",montant,Input.GetDate(),senderNome,receiverNome));
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(Red + "   Montant Non Valide  " + Reset);
                        error = true;
                    }
                } while (error);
            } else {
                System.out.print(Red+"\n\n   Aucun client associé à ce nom "+Reset);

            }


    }
    public static  void FaitRetrait() {

        boolean error = false;
        System.out.print("   Entrez l Nome client  : ");
        String senderNome = Input.GetInput();
        if (Input.ClientIsAvailable(senderNome) >= 0 ) {

            if (Input.AccountIsAvailable(senderNome)<0)
            {
                System.out.print(Red+"\n\n   Aucun Compte associé à ce nom "+Reset);
                return;
            }
            System.out.print("   Entrez le montant  Retrait  : ");
            do {
                try {
                    double montant = Integer.parseInt(Input.GetInput());
                    if (montant <= 0) {
                        error = true;
                        System.out.println(Red + "   Montant Non Valide  " + Reset);
                    } else {

                        if (DecreaseVairmentMontant((int) montant, Input.ClientIsAvailable(senderNome))) {
                            RetraitMontant((int) montant,Input.ClientIsAvailable(senderNome));
                            operations.add(new Model.Operation("Retrait ",montant,Input.GetDate(),senderNome,senderNome));
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println(Red + "   Montant Non Valide  " + Reset);
                    error = true;
                }
            } while (error);
        } else {
            System.out.print(Red+"\n\n   Aucun client associé à ce nom "+Reset);

        }
    }
    public static void FaitDepots() {

        boolean error = false;
        System.out.print("   Entrez l Nome client  : ");
        String senderNome = Input.GetInput();
        if (Input.ClientIsAvailable(senderNome) >= 0 ) {

            if (Input.AccountIsAvailable(senderNome)<0)
            {
                System.out.print(Red+"\n\n   Aucun Compte associé à ce nom "+Reset);
                return;
            }
            System.out.print("   Entrez le montant  : ");
            do {
                try {
                    double montant = Integer.parseInt(Input.GetInput());
                    if (montant <= 0) {
                        error = true;
                        System.out.println(Red + "   Montant Non Valide  " + Reset);
                    } else {

                        AddVairmentMontant((int) montant,Input.ClientIsAvailable(senderNome));
                        operations.add(new Model.Operation("Retrait ",montant,Input.GetDate(),senderNome,senderNome));
                    }
                } catch (NumberFormatException e) {
                    System.out.println(Red + "   Montant Non Valide  " + Reset);
                    error = true;
                }
            } while (error);
        } else {
            System.out.print(Red+"\n\n   Aucun client associé à ce nom "+Reset);

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
            return true;
        }
        else {
            System.out.print(Red + "\n  Votre solde est insuffisant " + Reset);
            return  false;
        }
    }
    private static void RetraitMontant(int montant, int id) {
        CompteCourant compteCourant=Compte.getcompteCourantList().get(id);
        compteCourant.setSolde(compteCourant.getSolde()-montant);
        System.out.print(Red + "\n  Votre Retrait a été effectué avec succès " + Reset);
    }

}
