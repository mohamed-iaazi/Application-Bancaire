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
                                 4) Modifier un Client info
                                 5) Exit
                    
                    
                    """);
            System.out.print("   Entrer Votre Choix : ");
            choix = Integer.parseInt(Input.GetInput());
            OnSelectedListnner onSelectedListnner = new GererCompte();
            onSelectedListnner.Select(choix);


        }
    }

    @Override
    public void Select(int Menu) {
        Services.Client client=new Services.Client();
        switch (Menu){
            case 1 -> client.Ajouter();
            case 2 -> client.Afficher();
            case 3 -> client.supprimer();
            case 4 -> client.Modifier();
            case 5 -> { }


        }
    }
}
