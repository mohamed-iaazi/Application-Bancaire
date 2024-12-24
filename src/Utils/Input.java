package Utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Input {



    public static boolean EmailValidor(String email){
      Pattern pattern=Pattern.compile("^[A-Z0-9a-z+.-_]+@[a-zA-Z+.]$");
      Matcher matcher=pattern.matcher(email);
      return matcher.matches();
    }

    public static String GetInput(){
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }

}
