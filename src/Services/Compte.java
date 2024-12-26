package Services;

import Interfaces.Crud;
import Model.CompteCourant;
import Model.CompteEpargne;
import Utils.Generate;
import Utils.Input;
import database.Historique;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import static Utils.Colors.*;

public class Compte implements Crud {
    private static ArrayList<Model.Compte> compteArrayList=new ArrayList<>();

    public static ArrayList<Model.Compte> getCompteArrayList() {
        return compteArrayList;
    }

    public static void setCompteArrayList(ArrayList<Model.Compte> compteArrayList) {
        Compte.compteArrayList = compteArrayList;
    }

    @Override
    public void supprimer() {

    }

    @Override
    public void Afficher() {

        if (!compteArrayList.isEmpty()) {
            for (Model.Compte client : compteArrayList) {
                System.out.print(Green+"\n\n-------------Id "+Reset+(client.getNumero())+Green+" -------------\n"+Reset
                        +Yellow+ "\n      Client Owner : "+ Reset +Client.getClientList().get(client.getProprietaire()).getName()
                        +Yellow+ "\n      Solde : "+Reset+client.getSolde()
                        +Yellow+ "\n      Creation Date : "+Reset+Historique.getOpereation().get(client.getProprietaire()).getDate()
                        +Yellow+ "\n      Compte Type : "+Reset+Historique.getOpereation().get(client.getProprietaire()).getType()
                        +Green+  "\n-------------------------------"+Reset
                );
            }
        }
    }

    @Override
    public void Ajouter() {
        int ClientId,compteType;
        double solde;
        String clientName;
        if (!Client.getClientList().isEmpty()) {
            do {
                System.out.print(Yellow + "\n   Entrez le nom du client pour lui associer un compte : " + Reset);
                clientName = Input.GetInput();
                if (Input.clientValidation(clientName)<0) {
                    System.out.println(Red + "\n   Ops Aucune Client à associer Avec cest Nome !   \n" + Reset);

                }
            } while (Input.clientValidation(clientName)<0);
            ClientId=Input.clientValidation(clientName)-1;
            System.out.println(Yellow+"\n----Type de compte---------   \n"+Reset);
            System.out.println(Green+"    1) CompteCourant   "+Reset);
            System.out.println(Green+"    2) CompteEpargne  "+Reset);
            System.out.print(Blue+"\n  Choisissez le type de compte : "+Reset);
            try {
                compteType = Integer.parseInt(Input.GetInput());
                System.out.print(Blue+"\n   Entrez le Solde initial   : "+Reset);
                solde= Double.parseDouble(Input.GetInput());
                if (compteType==1){
                    System.out.print(Green + "\n    Votre CompteCourant a été Ajouter avec succès " + Reset);
                    Input.setDate("CompteCourant",solde,ClientId);
                    compteArrayList.add(ClientId,new CompteCourant(
                            Generate.genarateNumero(),solde, ClientId,CalculeFraisBancaires(ClientId)));
                } else if (compteType==2)
                {
                    System.out.print(Green + "\n    Votre CompteEpargne a été Ajouter avec succès " + Reset);
                    Input.setDate("CompteEpargne",solde,ClientId);
                    compteArrayList.add(ClientId,new CompteEpargne(
                            Generate.genarateNumero(),solde,ClientId,TauxInteret()));
                }
                else {
                    System.out.println(Yellow + "\n   Invalide Type entree !   \n" + Reset);
                }

            }
            catch (NumberFormatException e){
                System.out.println(Red + "\n\n   Invalide entree !  " +e+ Reset);
            }

        }
        else {
            System.out.println(Red + "\n   Ops Aucune Client à associer !   \n" + Reset);

        }

    }

    @Override
    public void Modifier() {

    }

    private double CalculeFraisBancaires(int Id){
        return 0;
    }

    private double TauxInteret(){

        return 0;
    }
}