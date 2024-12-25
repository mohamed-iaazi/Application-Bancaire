package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private  int Id;
    private  String Name;
    private String Prenom;
    private String Email;
    private  String Adresse;



    public Client(int id, String name, String prenom, String email, String adresse) {
        Id = id;
        Name = name;
        Prenom = prenom;
        Email = email;
        Adresse = adresse;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }



}
