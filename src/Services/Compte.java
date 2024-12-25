package Services;

import Interfaces.Crud;
import Utils.Input;

import java.util.ArrayList;

import static Utils.Colors.*;

public class Compte implements Crud {
    private static ArrayList<Model.Compte> compteArrayList=new ArrayList<>();
    @Override
    public void supprimer() {

    }

    @Override
    public void Afficher() {

    }

    @Override
    public void Ajouter() {

    boolean valid=false;
    int  numero,solde,ClientId,compteType;
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
}
