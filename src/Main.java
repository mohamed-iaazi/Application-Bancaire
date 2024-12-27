import Menus.MainMenu;
import Utils.Input;

import static Utils.Colors.*;

//TIP TO Run <b>Main Menu</b>


public class Main {

    public static void main(String[] args)  {
        final String savedEmail = "admin@bank.com";
        final String savedPassword = "admin";
        boolean infoMatch=false;

        do {
            System.out.print(Blue + "\n Email : " + Reset);
            String email = Input.GetInput();
            System.out.print(Yellow + "\n Password : " + Reset);
            String password = Input.GetInput();
            if (savedEmail.equals(email)) {
                if (savedPassword.equals(password)) {
                    System.out.print(Green + "\n\n SuccesFuly Login \n\n" + Reset);
                    MainMenu.Menu();
                    infoMatch=true;
                } else {
                    System.out.print(Red + "\n\n Invalid Password " + Reset);

                }
            } else {
                System.out.print(Red + "\n\n Invalid Email " + Reset);
            }


        }while (!infoMatch);
    }
}