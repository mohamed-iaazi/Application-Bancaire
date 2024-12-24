package Menus;


import Interfaces.OnSelectedListnner;
import Utils.Input;


/* ##############################
  #         Lets Code By        #
 #           by Medo          #
 ##############################  */

public class GererClient implements OnSelectedListnner {

    // CLient Menu  where u can chose what do u want to do
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
                            
                                         1) Ajouter un Client
                                         2) Afficher les Clients 
                                         3) Supprimer un Client
                                         4) Modifier un Client info
                                         5) Back To Main
                            
                            
                            """);
                    System.out.print("   Entrer Votre Choix : ");
                    choix = Integer.parseInt(Input.GetInput());
                    OnSelectedListnner onSelectedListnner = new GererClient();
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
