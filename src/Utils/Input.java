package Utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public  class Input {



    public static boolean EmailValidor(String email){
        String regex="^[A-Z0-9a-z+.-_]+@[a-zA-Z+\\.]$";
        return Pattern.matches(email,regex);
    }

    public static String GetInput(){
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }


}
