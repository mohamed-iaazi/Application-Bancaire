package Menus;

import Interfaces.OnSelectedListnner;
import Utils.Input;

public class GererCompte implements OnSelectedListnner {
    public static void Menu() {
        int choix = 0;

        while (choix != 5) {
            System.out.println("""
                    #############################################
                    #                                           #
                    #                                           #
                    #                   Menu                    #
                    #                                           #
                    #                                           #
                    ##############################################
                    
                                 1) Ajouter un Compte
                                 2) Afficher les Compte detail 
                                 3) Supprimer un compte
                                 4) Modifier compte info
                                 5) Back To Main
                    
                    
                    """);
            System.out.print("   Entrer Votre Choix : ");
            choix = Integer.parseInt(Input.GetInput());
            OnSelectedListnner onSelectedListnner = new GererCompte();
            onSelectedListnner.Select(choix);


        }
    }

    @Override
    public void Select(int Menu) {
        Services.Compte compte=new Services.Compte();
        switch (Menu){
          


        }
    }
}
