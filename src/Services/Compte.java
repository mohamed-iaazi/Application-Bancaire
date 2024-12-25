package Services;

import Interfaces.Crud;
import Model.CompteCourant;
import Model.CompteEpargne;
import Utils.Generate;
import Utils.Input;

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

    }

    @Override
    public void Ajouter() {
    int ClientId=0,compteType;
    double solde;
    String clientName;
    if (!Client.getClientList().isEmpty()) {
        do {
            System.out.print(Yellow + "\n   Entrez le nom du client pour lui associer un compte : " + Reset);
            clientName = Input.GetInput();
            if (Input.clientValidation(clientName)<0) {
                System.out.println(Red + "\n   Ops Aucune Client à associer Avec cest Nome !   \n" + Reset);

            }
            else
            {
                ClientId=Input.clientValidation(clientName);
            }
        } while (Input.clientValidation(clientName)<0);
        System.out.println(Yellow+"\n----Type de compte---------   "+Reset);
        System.out.println(Green+"    1) CompteCourant   "+Reset);
        System.out.println(Green+"    2) CompteEpargne  "+Reset);
        System.out.print(Yellow+"  Choisissez le type de compte : "+Reset);
        try {
            compteType = Integer.parseInt(Input.GetInput());
            System.out.print(Yellow+"\n   Entrez le Solde initial   : "+Reset);
            solde= Double.parseDouble(Input.GetInput());
            if (compteType==1){
                Input.setDate("CompteCourant",solde,ClientId);
                compteArrayList.add(Input.clientValidation(clientName),new CompteCourant(Generate.genarateNumero(),solde,Input.clientValidation(clientName),CalculeFraisBancaires()));
            }
            else {
                compteArrayList.add(Input.clientValidation(clientName),new CompteEpargne(Generate.genarateNumero(),solde,Input.clientValidation(clientName),TauxInteret()));
            }

        }
        catch (NumberFormatException e){
            System.out.println(Red + "\n   Invalide entree !   \n" + Reset);
        }

    }
    else {
        System.out.println(Red + "\n   Ops Aucune Client à associer !   \n" + Reset);

    }

    }

    @Override
    public void Modifier() {

    }

    private double CalculeFraisBancaires(){

        return 0;
    }

    private double TauxInteret(){

        return 0;
    }
}
