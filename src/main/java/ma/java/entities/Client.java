package ma.java.entities;

import java.util.UUID;

public class Client {

/*    jouter un client : Le programme doit permettre à l'utilisateur d'ajouter un nouveau client en
    saisissant un identificateur unique*/

    private String id  ;

    private String name;


    public Client(){
        this.id = UUID.randomUUID().toString();
    }

    public Client(String name) {
        this();
        this.name = name;
    }


    public  String getId() {
        return id;
    }

    public  void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
