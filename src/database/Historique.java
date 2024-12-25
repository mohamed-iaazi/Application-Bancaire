package database;

import Model.Operation;

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

    }
}
