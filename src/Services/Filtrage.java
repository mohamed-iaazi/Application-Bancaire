package Services;

import Model.CompteCourant;
import Utils.Input;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Filtrage {

    public  static  void FiltrageByDate(){
        Stream<CompteCourant> filtrageCompteCourant=Services.Compte.getcompteCourantList().stream().filter(compte -> compte.getDate().isAfter(Input.GetDate()));
        filtrageCompteCourant.forEach( obj -> System.out.println(obj.toString()));
    }

    public  static  void FiltrageByMinSolde(){
        System.out.println(Yellow+"\n Filtrage By Min Solde : \n"+Reset);
        Services.Compte.getcompteCourantList()
                // comparator  increase
                .stream().sorted(Comparator.comparingDouble(CompteCourant::getSolde)).forEach(a-> System.out.println(a.getCompte()));
    }

    public  static  void FiltrageByTypeTransaction(){
       Compte.getcompteCourantList().stream().forEach( compte -> System.out.println(compte));
    }
}
