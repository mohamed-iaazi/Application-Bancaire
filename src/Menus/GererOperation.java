package Menus;

import Interfaces.OnSelectedListnner;
import Utils.Input;
import static Services.Operation.*;
import static Utils.Colors.*;
import static Utils.Colors.Reset;
import static database.Historique.Afficher;

public class GererOperation implements OnSelectedListnner {
    public static void Menu()  {
        int choix = 0;

        while (choix != 5) {
            System.out.println(Blue+"""
                    
                    
                    #############################################
                    #                                           #
                    #                                           #
                    #              Operation Menu               #
                    #                                           #
                    #                                           #
                    ##############################################
                    
                                 1) Fait un virement
                                 2) Fait un retrait
                                 3) Fait un dépôts
                                 4) Historique 
                                 5) Back To Main
                    
                    
                    """+Reset);
            System.out.print(Green+"   Entrer Votre Choix : "+Reset);

            try {
                choix = Integer.parseInt(Input.GetInput());
                OnSelectedListnner onSelectedListnner = new GererOperation();
                onSelectedListnner.Select(choix);
            }
            catch (NumberFormatException e){
                System.out.println(Red+"\n\n   Invalid Entry ! \n\n"+Reset);
            }
        }
    }

    @Override
    public void Select(int Menu) {
        switch (Menu){
            case 1 ->Virment();
            case 2 ->Retrait();
            case 3 ->Depots();
            case 4 -> Afficher();
            case 5 ->  // To get BAck To main Menu
                    System.out.println(Blue+"\n\n  Back To Main ! \n\n"+Reset);
        }
    }
}
