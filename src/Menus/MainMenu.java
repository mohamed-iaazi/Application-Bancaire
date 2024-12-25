package Menus;

import Interfaces.OnSelectedListnner;
import Utils.Input;

import static Utils.Colors.*;

public class MainMenu   implements OnSelectedListnner  {


    public static void Menu()   {




        int choix=0;

        while (choix!=5){
            System.out.println(Green+"""
                                 #############################################
                                 #                                           #
                                 #                                           #
                                 #                Main Menu                  #
                                 #                                           #
                                 #                                           #
                                 ##############################################
                    
                                              1) Gerer  Client
                                              2) Gerer Compte 
                                              3) Gerer Operation
                                              4) Filtrage
                                              5) Exit
                                          
                    
                                 """+Reset);
              System.out.print(  Yellow+"   Entrer Votre Choix : "+Reset);

              try {
                  choix= Integer.parseInt(Input.GetInput());
                  OnSelectedListnner onSelectedListnner=new MainMenu();
                  onSelectedListnner.Select(choix);

              }
              catch (NumberFormatException numberFormatException){
                  System.out.println(Red+"\n\n   Invalid Entry ! \n\n"+Reset);
              }


        }


    }

    @Override
    public void Select(int Menu)  {

        switch (Menu){
            case 1 -> GererClient.Menu();
            case 2 -> GererCompte.Menu();
            case 3 -> GererOperation.Menu();
            case 4 -> Filtrage.Menu();
            case 5 -> { }
          default -> { }

        };

    }


}
