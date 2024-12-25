package Services;

import Interfaces.Crud;
import Utils.Colors;
import Utils.Input;

import java.util.ArrayList;

import static Utils.Colors.*;

public class Client implements Crud {
    private static ArrayList<Model.Client> ClientList=new ArrayList<>();
    private static int Id;

    public static ArrayList<Model.Client> getClientList() {
        return ClientList;
    }

    public static void setClientList(ArrayList<Model.Client> clientList) {
        ClientList = clientList;
    }

    @Override
    public void supprimer() {
        boolean available=false;
        if (!ClientList.isEmpty()) {
        while (!available) {

                System.out.print(Yellow + "\n\n   Entrer Le Id De Client Pour Supprimer :  " + Reset);

                for (int i=0;i<ClientList.size();i++) {

                    if (Integer.parseInt(Input.GetInput()) == ClientList.get(i).getId()) {
                        Id=i;

                        available=true;
                    }


                }

                if (available){
                    ClientList.remove(Id);
                    System.out.print(Green + "\n    Le client a été supprimé avec succès " + Reset);
                }
                else {
                    System.out.println(Red + "\n\n      L'identifiant ne correspond à aucun client  " + Reset);

                }
            }
        }
        else {
            System.out.println(Red + "\n\n   Aucune Client à Supprimer  \n" + Reset);
        }
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
                System.out.print(Green + "\n   Le client a été Ajouter avec succès " + Reset);
                ClientList.add(new Model.Client(Id,name,Last,Email,Address));
            } else if (!Input.EmailValidor(Email)) {
                System.out.println(Red+"   Email Non Valide  "+Reset);

            }

        }
    }

    @Override
    public void Modifier() {
        boolean available=false;
        boolean valid=false;

        if (!ClientList.isEmpty()) {
            while (!available) {
                System.out.print(Yellow + "\n\n   Entrer Le Id De Client Pour Modifier :  " + Reset);
                int Id=Integer.parseInt(Input.GetInput());
                for (int i = 0; i < ClientList.size(); i++) {

                    if (Id == ClientList.get(i).getId()) {

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
                                available=true;
                                System.out.print("   Entrer  Adress : ");
                                Address= Input.GetInput();
                                ClientList.set(i,new Model.Client(Id,name,Last,Email,Address));
                            } else if (!Input.EmailValidor(Email)) {
                                System.out.println(Red+"   Email Non Valide  "+Reset);

                            }

                        }
                    }


                }

                if (available){
                    System.out.print(Green + "   Le client a été Modifier avec succès " + Reset);
                }
                else {
                    System.out.println(Red + "\n\n      L'identifiant ne correspond à aucun client  " + Reset);

                }

            }
        }
        else {
            System.out.println(Red + "\n\n   Aucune Client à Modifier  \n" + Reset);
        }
    }


}


