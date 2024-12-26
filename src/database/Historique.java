package database;

import static Utils.Colors.Green;
import static Utils.Colors.Reset;
import static Utils.Colors.Yellow;

import Model.Operation;
import Services.Client;
import Services.Compte;

import java.util.ArrayList;

public class Historique {
    static ArrayList<Operation> Opereation=new ArrayList<>();

    public static ArrayList<Operation> getOpereation() {
        return Opereation;
    }



    public static void setOpereation(ArrayList<Operation> opereation) {
        Opereation = opereation;
    }

    public static void Afficher() {

        if (!Opereation.isEmpty()) {
            for (Operation client : Opereation) {
                System.out.print(Green+"\n\n-------------Id "+Reset+(client.getCompteAssocie()+1)+Green+" -------------\n"+Reset
                        +Yellow+ "\n      Account Type : "+ Reset +client.getType()
                        +Yellow+ "\n      Montant : "+Reset+client.getMontant()
                        +Yellow+ "\n      Creation Date : "+Reset+client.getDate()
                        +Yellow+ "\n      Compte Numero : "+Reset+"Ma 64000000"
                        + Compte.getCompteArrayList().get(client.getCompteAssocie()).getNumero()
                        +Green+  "\n-------------------------------"+Reset
                );
            }
        }
    }
}