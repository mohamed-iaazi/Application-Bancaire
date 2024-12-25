package Services;

import Interfaces.Crud;
import Model.CompteCourant;
import Model.CompteEpargne;
import Utils.Generate;
import Utils.Input;

import java.util.ArrayList;
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
    int  numero ,ClientId,compteType;
    double solde,fraisBancaires,tauxIntert;
    String ClientName;
    if (!Client.getClientList().isEmpty()) {
        System.out.print(Yellow+"\n   Entrez le nom du client pour lui associer un compte : "+Reset);
        ClientName = Input.GetInput();
        System.out.println(Yellow+"\n----Type de compte---------   "+Reset);
        System.out.println(Green+"    1) CompteCourant   "+Reset);
        System.out.println(Green+"    2) CompteEpargne  "+Reset);
        System.out.println(Yellow+"  Choisissez le type de compte : "+Reset);
        try {
            compteType = Integer.parseInt(Input.GetInput());
            System.out.print(Yellow+"\n   Entrez le Solde initial   : "+Reset);
            solde= Double.parseDouble(Input.GetInput());


            if (compteType==1){
                compteArrayList.add(new CompteCourant(Generate.genarateNumero(),solde,null,0));
            }
            else {
                compteArrayList.add(new CompteEpargne(Generate.genarateNumero(),solde,null,0));
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

    private int CalculeFraisBancaires(char compteType){

        return 0;
    }

    private int tauxInteret(char compteType){

        return 0;
    }
}
