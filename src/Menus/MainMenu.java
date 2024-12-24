package Menus;

import Interfaces.Crud;
import Interfaces.OnSelectedListnner;
import Services.Client;
import Services.Compte;
import Services.Operation;
import Utils.Input;

public class MainMenu   implements OnSelectedListnner {



    public static void Menu()  throws Exception {




        int choix=0;

        while (choix!=5){
            System.out.println("""
                                 #############################################
                                 #                                           #
                                 #                                           #
                                 #                   Menu                    #
                                 #                                           #
                                 #                                           #
                                 ##############################################
                    
                                              1) Gerer  Client
                                              2) Gerer Compte 
                                              3) Gerer Operation
                                              4) Filtrage
                                              5) Exit
                                          
                    
                                 """);
              System.out.print(  "   Entrer Votre Choix : ");
              choix= Integer.parseInt(Input.GetInput());

//              MainMenu mainMenu=new MainMenu();
//              mainMenu.Select(choix);

            OnSelectedListnner onSelectedListnner=new MainMenu();
            onSelectedListnner.Select(choix);

        }


    }

    @Override
    public void Select(int Menu) {

        switch (Menu){
            case 1 -> GererCompte.Menu();
            case 2 -> GererClient.Menu();
            case 3 -> GererOperation.Menu();
            case 4 -> Filtrage.Menu();
            case 5 -> { }



        }

    }


}
