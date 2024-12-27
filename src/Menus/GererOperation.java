package Menus;

import Interfaces.OnSelectedListnner;
import Services.Client;
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
                                 5) Retour au  Principal
                    
                    
                    """+Reset);
            System.out.print(Green+"   Entrer Votre Choix : "+Reset);

            try {
                choix = Integer.parseInt(Input.GetInput());
                OnSelectedListnner onSelectedListnner = new GererOperation();
                onSelectedListnner.Select(choix);
            }
            catch (NumberFormatException e){
                System.out.println(Red+"\n\n   Entree invalide ! \n\n"+Reset);
            }
        }
    }

    @Override
    public void Select(int Menu) {

        if (!Client.getClientList().isEmpty()) {
            switch (Menu) {
                case 1 -> FaitVairment();
                case 2 -> FaitRetrait();
                case 3 -> FaitDepots();
                case 4 -> Afficher();
                case 5 ->  // To get BAck To main Menu
                        System.out.println(Blue + "\n\n  Retour au  Principal ! \n\n" + Reset);
            }
        } else if (Menu!=5) {
            System.out.print(Red+"\n\n   Aucun client pour faire Des Opearation "+Reset);
        }
        else {
            System.out.println(Blue + "\n\n  Retour au  Principal ! \n\n" + Reset);
        }

    }
}
