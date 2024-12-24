package Services;

import Interfaces.Crud;
import Utils.Input;

public class Client implements Crud {


    @Override
    public void supprimer() {

    }

    @Override
    public void Afficher() {
        String name,Last,Email,Address;

        System.out.print("   Enter The Name : ");
         name= Input.GetInput();
        System.out.print("   Enter The Last  Name : ");
        Last= Input.GetInput();
        System.out.print("   Enter The Email : ");
        Email= Input.GetInput();
        System.out.print("   Enter The Adress : ");
        Address= Input.GetInput();

    }

    @Override
    public void Ajouter() {

    }

    @Override
    public void Modifier() {

    }
}
