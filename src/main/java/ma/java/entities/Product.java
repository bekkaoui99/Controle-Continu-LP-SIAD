package ma.java.entities;

import java.util.UUID;

public class Product {

/*
    Ajouter un produit : Le programme doit permettre à l'utilisateur d'ajouter un nouveau produit
    en saisissant son nom, son prix et sa quantité initiale en stock.
- Modifier un produit : L'utilisateur doit pouvoir sélectionner un produit et modifier ses
    informations telles que le prix et la quantité en stock.
            - Afficher la liste des produits : Le programme doit afficher la liste de tous les produits
    disponibles avec leurs détails (nom, prix, quantité en stock).*/

    private String id ;

    private String name;

    private double price;

    private int quantity;


    public Product(){
        this.id = UUID.randomUUID().toString();
    }


    public Product(String name, double price, int quantity) {
        this();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
