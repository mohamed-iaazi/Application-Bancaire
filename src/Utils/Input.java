package Utils;

import Model.Operation;
import Services.Client;
import Services.Compte;
import database.Historique;

import java.time.Duration;
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

    public  static LocalDate GetDate(){
        LocalDate localDate=LocalDate.now();
        return  localDate;
    }

}
