package Utils;

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


}
