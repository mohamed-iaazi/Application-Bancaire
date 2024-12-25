package Menus;

import Interfaces.OnSelectedListnner;
import Services.Compte;
import Utils.Input;

import static Utils.Colors.*;

public class GererCompte  extends Compte implements OnSelectedListnner {
    public static void Menu()  {
        int choix = 0;

        while (choix != 5) {
            System.out.println(Blue+"""
                    
                    
                    #############################################
                    #                                           #
                    #                                           #
                    #              Compte Menu                  #
                    #                                           #
                    #                                           #
                    ##############################################
                    
                                 1) Ajouter un Compte
                                 2) Afficher les Compte détaill
                                 3) Supprimer un compte
                                 4) Modifier compte info
                                 5) Retour au  Principal
                    
                    
                    """+Reset);
            System.out.print(Green+"   Entrer Votre Choix : "+Reset);

            try {
                choix = Integer.parseInt(Input.GetInput());
                OnSelectedListnner onSelectedListnner = new GererCompte();
                onSelectedListnner.Select(choix);
            }
            catch (NumberFormatException e){
                System.out.println(Red+"\n\n   Entree invalide ! \n\n"+Reset);
            }


        }
    }

    @Override
    public void Select(int Menu) {
        Services.Compte compte=new Services.Compte();
        switch (Menu){
            case 1 -> Ajouter();
            case 2 -> Afficher();
            case 3 -> supprimer();
            case 4 -> Modifier();
            case 5 ->  // To get BAck To main Menu
                System.out.println(Blue+"\n\n  Retour au principal ! \n\n"+Reset);




        }
    }
}
