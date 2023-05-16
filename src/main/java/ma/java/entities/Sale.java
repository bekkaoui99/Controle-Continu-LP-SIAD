package ma.java.entities;

import java.util.UUID;

public class Sale {

/*    Enregistrer une vente : Le programme doit permettre à l'utilisateur d'enregistrer une vente en
    sélectionnant un client et les produits achetés avec leurs quantités respectives. Les quantités
    des produits vendus doivent être déduites de leur stock.
- Afficher les transactions : Le programme doit afficher la liste des transactions de vente avec
    les détails de chaque transaction (client, produits achetés, prix total)*/

    private String id ;

    private String client;

    private String product;

    private int quantity;


    private double totalPrice ;



    public Sale(){
        this.id = UUID.randomUUID().toString();
    }

    public Sale(String client, String product, int quantity, double totalPrice) {
        this();
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
