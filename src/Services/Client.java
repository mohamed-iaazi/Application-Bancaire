package Services;

import Interfaces.Crud;
import Utils.Input;

import java.util.ArrayList;

public class Client implements Crud {
    private static ArrayList<Model.Client> ClientList=new ArrayList<>();
    private static int Id;


    @Override
    public void supprimer() {

    }

    @Override
    public void Afficher() {



    }

    @Override
    public void Ajouter() {
        boolean valid=false;
        String name,Last,Email,Address;
        System.out.print("   Enter The Name : ");
        name= Input.GetInput();
        System.out.print("   Enter The Last  Name : ");
        Last= Input.GetInput();

        while (!valid) {
            System.out.print("   Enter The Email : ");
            Email = Input.GetInput();
            if (Input.EmailValidor(Email)) {
                valid=true;
                System.out.print("   Enter The Adress : ");
                Address= Input.GetInput();
                ClientList.add(new Model.Client(Id+1,name,Last,Email,Address));
            } else if (!Input.EmailValidor(Email)) {
                System.out.println("  Envalid Email");

            }

        }
    }

    @Override
    public void Modifier() {

    }
}
