package Services;

import Interfaces.Crud;
import Utils.Colors;
import Utils.Input;

import java.util.ArrayList;

import static Utils.Colors.*;

public class Client implements Crud {
    private static ArrayList<Model.Client> ClientList=new ArrayList<>();
    private static int Id;


    @Override
    public void supprimer() {

    }

    @Override
    public void Afficher() {
        if (!ClientList.isEmpty()) {
            for (Model.Client client : ClientList) {
                System.out.print(Green+"\n\n-------------Id "+Reset+client.getId()+Green+" -------------\n"+Reset
                                +Yellow+ "\n      Nome : "+ Reset +client.getName()
                                +Yellow+ "\n      Prenom : "+Reset+client.getPrenom()
                                +Yellow+ "\n      Email : "+Reset+client.getEmail()
                                +Yellow+ "\n      Adress : "+Reset+client.getAdresse()
                                +Green+  "\n-------------------------------"+Reset
                 );
            }
        }
        else {
            System.out.println(Red+"\n\n   Aucune Client à afficher  "+Reset);
        }
    }

    @Override
    public void Ajouter() {
        boolean valid=false;
        String name,Last,Email,Address;
        System.out.print("   Entrer Le Nome : ");
        name= Input.GetInput();
        System.out.print("   Entrer Prenom : ");
        Last= Input.GetInput();

        while (!valid) {
            System.out.print("   Entrer  Email : ");
            Email = Input.GetInput();
            if (Input.EmailValidor(Email)) {
                valid=true;
                System.out.print("   Entrer  Adress : ");
                Address= Input.GetInput();
                if (!ClientList.isEmpty()) {
                    Id = ClientList.getLast().getId() + 1;
                }
                else {
                    Id=Id+1;
                }

                ClientList.add(new Model.Client(Id,name,Last,Email,Address));
            } else if (!Input.EmailValidor(Email)) {
                System.out.println(Red+"   Email Non Valide  "+Reset);

            }

        }
    }

    @Override
    public void Modifier() {

    }
}
