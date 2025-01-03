package Utils;

import Model.CompteEpargne;
import Services.Client;
import Services.Compte;


import java.util.Random;

import static Utils.Colors.Red;
import static Utils.Colors.Reset;

public class Generate {

    public static int genarateNumero(){
        Random random=new Random();
        int  numero;
        boolean taken=false;
        do {
            int genrateNum = random.nextInt(100000000);
            numero=genrateNum;
            if (!Client.getClientList().isEmpty()) {
                for (Model.Compte compte : Compte.getcompteCourantList()) {
                    if (compte.getNumero() == genrateNum) {
                        for (CompteEpargne compteEpargne: Compte.getCompteEpargneArrayLists()){
                            if (compteEpargne.getNumero()==genrateNum){
                                System.out.println(Red+"  # Génération automatique de numéros  .....  "+Reset);
                                taken=true;
                                break;
                            }
                        }

                    }
                }
            }
        } while (taken);


        return numero;
    }
}
