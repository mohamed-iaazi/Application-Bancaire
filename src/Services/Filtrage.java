package Services;

import Model.CompteCourant;
import Utils.Input;
import java.util.stream.Stream;

public class Filtrage {

    public  static  void FiltrageByDate(){
        Stream<CompteCourant> filtrageCompteCourant=Services.Compte.getcompteCourantList().stream().filter(compte -> compte.getDate().isAfter(Input.GetDate()));
        filtrageCompteCourant.forEach( obj -> System.out.println(obj.toString()));
    }

    public  static  void FiltrageByMinSolde(){
        Stream<CompteCourant> filtrageCompteCourant=Services.Compte.getcompteCourantList().stream().filter(compte -> compte.getSolde() > 0);
        filtrageCompteCourant.forEach( obj -> System.out.println(obj.toString()));
    }

    public  static  void FiltrageByTypeTransaction(){
        Stream<CompteCourant> filtrageCompteCourant=Services.Compte.getcompteCourantList().stream().filter(compte -> compte.equals(""));
        filtrageCompteCourant.forEach( obj -> System.out.println(obj.toString()));
    }
}
