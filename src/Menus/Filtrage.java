package Menus;

import Interfaces.OnSelectedListnner;
import Utils.Input;

import static Utils.Colors.*;
import static Utils.Colors.Reset;

public class Filtrage  implements OnSelectedListnner{
    public static void Menu() {
        int choix = 0;
        while (choix != 4) {
            System.out.println(Blue+"""
                            
                            
                            #############################################
                            #                                           #
                            #                                           #
                            #               Filtrage Menu               #
                            #                                           #
                            #                                           #
                            ##############################################
                            
                                         1) Filtrage Operation avec Date
                                         2) Filtrage par Type de Transaction
                                         3) Filtrage par Solde Minimum
                                         4) Retour au  Principal
                            
                            
                            """+Reset);
            System.out.print(Green+"   Entrer Votre Choix : "+Reset);
            try {


                choix = Integer.parseInt(Input.GetInput());
                OnSelectedListnner onSelectedListnner = new Filtrage();
                onSelectedListnner.Select(choix);

            }
            catch (NumberFormatException e){
                System.err.println("\n\n   Entree invalide ! \n\n");
            }


        }

    }

    @Override
    public void Select(int Menu) {
        switch (Menu){
            case 1 -> Services.Filtrage.FiltrageByDate();
            case 2 -> Services.Filtrage.FiltrageByTypeTransaction();
            case 3 -> Services.Filtrage.FiltrageByMinSolde();
            case 4 -> System.out.println(Blue+"\n\n  Retour au  Principal ! \n\n"+Reset);



        }
    }
}

