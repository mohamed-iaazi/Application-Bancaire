package database;

import Model.Operation;
import Services.Compte;

import java.util.ArrayList;

import static Utils.Colors.*;

public class Historique {
    private static ArrayList<Operation> Opereation = new ArrayList<>();


    public static void Afficher() {

        if (!Services.Operation.getOperations().isEmpty()) {
            for (Operation operation : Services.Operation.getOperations()) {
                System.out.println(Blue + operation.toString() + Reset);
            }
        }
        else System.err.println("\n\n  No Operation Pour Afficher");
    }
}
