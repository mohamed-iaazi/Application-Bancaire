package Utils;


import Services.Client;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;


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

    public static int ClientIsAvailable(String Name){
        int index =-1;
        for (int i = 0; i < Client.getClientList().size(); i++) {
            if (Objects.equals(Name, Client.getClientList().get(i).getName())){

                index=i;
            }
        }

        return index;
    }


}
