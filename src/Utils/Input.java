package Utils;

import Model.Client;
import Model.Operation;
import database.Historique;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import static Services.Client.getClientList;
import static Utils.Colors.*;

public  class Input {



    public static boolean EmailValidor(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex,email);
    }

    public static String GetInput(){
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int clientValidation(String ClientName){
        int index=-1;
        for (int i = 0; i < getClientList().size(); i++) {
            if (ClientName.equals(getClientList().get(i).getName())){
                 index=i;
            }
        }
        return index;

    }

    public  static  void setDate(String compteType,double montant,int Index){
        LocalDate myObj = LocalDate.now();
        Historique.getOpereation().add(new Operation(compteType,montant,myObj,Index));
    }
}
