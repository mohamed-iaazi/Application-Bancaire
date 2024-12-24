package Menus;

import Interfaces.OnSelectedListnner;
import Utils.Input;

import static Utils.Colors.*;

public class GererCompte  implements OnSelectedListnner {
    public static void Menu()  {
        int choix = 0;

        while (choix != 5) {
            System.out.println(Blue+"""
                    #############################################
                    #                                           #
                    #                                           #
                    #                   Menu                    #
                    #                                           #
                    #                                           #
                    ##############################################
                    
                                 1) Ajouter un Compte
                                 2) Afficher les Compte détaill
                                 3) Supprimer un compte
                                 4) Modifier compte info
                                 5) Back To Main
                    
                    
                    """+Reset);
            System.out.print(Green+"   Entrer Votre Choix : "+Reset);

            try {
                choix = Integer.parseInt(Input.GetInput());
                OnSelectedListnner onSelectedListnner = new GererCompte();
                onSelectedListnner.Select(choix);
            }
            catch (NumberFormatException e){
                System.out.println(Red+"\n\n   Invalid Entry ! \n\n"+Reset);
            }


        }
    }

    @Override
    public void Select(int Menu) {
        Services.Compte compte=new Services.Compte();
        switch (Menu){
            case 1 -> compte.Ajouter();
            case 2 -> compte.Afficher();
            case 3 -> compte.supprimer();
            case 4 -> compte.Modifier();
            case 5 -> { // To get BAck To main Menu

                }


        }
    }
}
