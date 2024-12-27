package Services;

import Interfaces.Crud;
import Model.CompteCourant;
import Model.CompteEpargne;
import Utils.Generate;
import Utils.Input;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;
import static Utils.Colors.*;

public class Compte implements Crud {

        private static ArrayList<CompteCourant> compteCourantArrayLists = new ArrayList<>();
        private static ArrayList<CompteEpargne> compteEpargneArrayLists = new ArrayList<>();
        static double fraisBancairs,tauxInteret;

    public static ArrayList<CompteCourant> getCompteLists() {
        return compteCourantArrayLists;
    }

    public static void setCompteLists(ArrayList<CompteCourant> compteLists) {
        Compte.compteCourantArrayLists = compteLists;
    }

    public static ArrayList<CompteEpargne> getCompteEpargneArrayLists() {
        return compteEpargneArrayLists;
    }

    public static void setCompteEpargneArrayLists(ArrayList<CompteEpargne> compteEpargneArrayLists) {
        Compte.compteEpargneArrayLists = compteEpargneArrayLists;
    }

    @Override
    public void supprimer() {
        // To Do
    }

    @Override
    public void Afficher() {
        if (!compteCourantArrayLists.isEmpty()) {
         DisplayCompteCourant();
        }

        else {
            System.out.println("\n\n    No The compteCourant To display");
        }

        if (!compteEpargneArrayLists.isEmpty()) {
          DisplayCompteEpargne();
        }

        else {
            System.out.println("\n\n   No compteEpargne To display ");
        }

    }

    @Override
    public void Ajouter() {
        if (Client.getClientList().isEmpty()) {
            System.out.println(Red + "\n   Ops Aucune Client à associer !   \n" + Reset);
            return;
        }
        String clientName;
        int clientId, compteType;
        double solde;

        do {
            System.out.print(Yellow + "\n   Entrez le nom du client pour lui associer un compte : " + Reset);
            clientName = Input.GetInput();
        }while (ClientIsAvailable(clientName)<0);
        try {
            clientId=ClientIsAvailable(clientName);
            System.out.println(Yellow + "\n----Type de compte---------\n" + Reset);
            System.out.println(Green + "    1) CompteCourant" + Reset);
            System.out.println(Green + "    2) CompteEpargne" + Reset);
            System.out.print(Blue + "\n  Choisissez le type de compte : " + Reset);
            compteType = Integer.parseInt(Input.GetInput());
            System.out.print(Blue + "\n   Entrez le Solde initial : " + Reset);
            solde = Double.parseDouble(Input.GetInput());
            if (compteType==1){
                compteCourantArrayLists.add(new CompteCourant(Generate.genarateNumero(),solde,clientId,Input.GetDate(),fraisBancairs));
                System.out.print(Green + "\n   Votre Compte a été Ajouter avec succès " + Reset);
                CalculeFrais(clientId);

            } else if (compteType==2) {
                compteEpargneArrayLists.add(new CompteEpargne(Generate.genarateNumero(),solde,clientId,Input.GetDate(),tauxInteret));
                System.out.print(Green + "\n   Votre Compte a été Ajouter avec succès " + Reset);
                CalculeTaux(clientId);
            }
            else {
                // Invalid Type Account
            }

        }catch (Exception e){

        }

    }

    @Override
    public void Modifier() {
        // To Do
        }


    public int ClientIsAvailable(String Name){
   int index =-1;
        for (int i = 0; i < Client.getClientList().size(); i++) {
            if (Objects.equals(Name, Client.getClientList().get(i).getName())){

                index=i;
            }
        }

        return index;
    }
     public void CalculeFrais(int  Id){
         for (int i = 0; i < compteCourantArrayLists.size() ; i++) {
             if (compteCourantArrayLists.get(i).getProprietaire()==Id){

                 LocalDate creatingDate=compteCourantArrayLists.get(i).getDate();
                 LocalDate nowDate=LocalDate.now();
                 long daysBetween = ChronoUnit.DAYS.between(creatingDate, nowDate);
                 if (daysBetween>335||daysBetween==0){
                     compteCourantArrayLists.get(i).setFraisBancaires(59);
                    compteCourantArrayLists.get(i).setSolde(compteCourantArrayLists.get(i).getSolde()-59);
                     System.out.print(Red + "\n\n    Les frais bancaires ont été payés avec succès -59 Dh \n\n" + Reset);
                 }
                 else {
                     System.out.print(Green + "\n\n   Acune  frais bancaires Pour payés  " + Reset);
                 }
             }
         }
     }

     public  void CalculeTaux(int Id){
         for (int i = 0; i < compteEpargneArrayLists.size() ; i++) {
             if (compteEpargneArrayLists.get(i).getProprietaire()==Id){

                 LocalDate creatingDate=compteEpargneArrayLists.get(i).getDate();
                 LocalDate nowDate=LocalDate.now();
                 long daysBetween = ChronoUnit.DAYS.between(creatingDate, nowDate);
                 if (daysBetween>335||daysBetween==0){
                     compteEpargneArrayLists.get(i).setTauxInteret(500);
                     compteEpargneArrayLists.get(i).setSolde(compteEpargneArrayLists.get(i).getSolde()+500);
                     System.out.print(Red + "\n\n    les tauxInteret ont été ajouter avec succès +500 Dh \n\n" + Reset);
                 }
                 else {
                     System.out.print(Green + "\n\n   Acune  tauxInteret  Pour ajouter  " + Reset);
                 }
             }
         }

     }

     public void DisplayCompteEpargne(){
         for (int i = 0; i < compteEpargneArrayLists.size(); i++) {

             System.out.println(Green+"\n\n-------------Id "+Reset+(compteEpargneArrayLists.get(i).getProprietaire()+1)+Green+" -------------\n"+Reset
                     +Blue+ "\n      Client Owner : "+ Reset +Client.getClientList().get(compteEpargneArrayLists.get(i).getProprietaire()).getName()
                     +Blue+ "\n      Solde : "+Reset+compteEpargneArrayLists.get(i).getSolde()+" DH"
                     +Blue+ "\n      tauxInteret : "+Reset+compteEpargneArrayLists.get(i).getTauxInteret()
                     +Blue+ "\n      Creation Date : "+Reset+compteEpargneArrayLists.get(i).getDate()
                     +Blue+ "\n      Compte Type : "+Reset+" compteEpargne "
                     +Green+  "\n-------------------------------"+Reset
             );


         }

     }

     public  void DisplayCompteCourant(){
         for (int i = 0; i < compteCourantArrayLists.size(); i++) {

             System.out.println(Green+"\n\n-------------Id "+Reset+(compteCourantArrayLists.get(i).getProprietaire()+1)+Green+" -------------\n"+Reset
                     +Yellow+ "\n      Client Owner : "+ Reset +Client.getClientList().get(compteCourantArrayLists.get(i).getProprietaire()).getName()
                     +Yellow+ "\n      Solde : "+Reset+compteCourantArrayLists.get(i).getSolde()+" DH"
                     +Yellow+ "\n      fraisBancaire : "+Reset+compteCourantArrayLists.get(i).getFraisBancaires()
                     +Yellow+ "\n      Creation Date : "+Reset+compteCourantArrayLists.get(i).getDate()
                     +Yellow+ "\n      Compte Type : "+Reset+" compteCourant "
                     +Green+  "\n-------------------------------"+Reset
             );


         }
     }


}
