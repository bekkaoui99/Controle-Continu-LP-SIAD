import ma.java.entities.Client;
import ma.java.entities.Product;
import ma.java.entities.Sale;
import ma.java.exception.ClientNotFoundException;
import ma.java.exception.ProductNotFoundExeption;
import ma.java.exception.QuantityNotAvailable;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercice2 {

    public static void main(String[] args) throws Exception {
        int choose = -1;

        final String product_db = "product.txt";
        final String client_db = "client.txt";
        final String sale_db = "sale.txt";

        List<Product> listProduct = new ArrayList<>();
        List<Client> listClient = new ArrayList<>();
        List<Sale> listSale = new ArrayList<>();

        List<String>  list_product_id = new ArrayList<>();
        List<String>  list_product_name = new ArrayList<>();
        List<Double>  list_product_price = new ArrayList<>();
        List<Integer> list_product_quantity = new ArrayList<>();

        List<String>  list_client_id = new ArrayList<>();
        List<String>  list_client_name = new ArrayList<>();




        BufferedReader readInProduct = new BufferedReader(new FileReader(product_db));
        String line_Product ;
        while ((line_Product = readInProduct.readLine())!= null){


            if(line_Product.startsWith("id")){
                String id = line_Product.substring(line_Product.indexOf(":") + 1);
                list_product_id.add(id);

            }
            else if(line_Product.startsWith("name")){
                String name = line_Product.substring(line_Product.indexOf(":") + 1);
                list_product_name.add(name);

            }
            else if(line_Product.startsWith("price")){
                String price = line_Product.substring(line_Product.indexOf(":") + 1);
                list_product_price.add(Double.parseDouble(price));

            }
            else if(line_Product.startsWith("quantity")){
                String quantity = line_Product.substring(line_Product.indexOf(":") + 1);
                list_product_quantity.add(Integer.parseInt(quantity));

            }


        }

        for (int i = 0 ; i < list_product_id.size() ; i++){
            Product product = new Product();
            product.setId(list_product_id.get(i));
            product.setName(list_product_name.get(i));
            product.setPrice(list_product_price.get(i));
            product.setQuantity(list_product_quantity.get(i));
            listProduct.add(product);
        }


        BufferedReader readInClient = new BufferedReader(new FileReader(client_db));
        String line_client ;
        while ((line_client = readInClient.readLine())!= null){


            if(line_client.startsWith("id")){
                String id = line_client.substring(line_client.indexOf(":") + 1);
                list_client_id.add(id);

            }
            else if(line_client.startsWith("name")){
                String name = line_client.substring(line_client.indexOf(":") + 1);
                list_client_name.add(name);

            }


        }

        for (int i = 0 ; i < list_client_id.size() ; i++){
            Client client = new Client();
            client.setId(list_client_id.get(i));
            client.setName(list_client_name.get(i));
            listClient.add(client);
        }


        do {
            try {
                System.out.println("***************************************************************");

                System.out.println("| if you want to create a product use number one  => 1        |");
                System.out.println("| if you want to update a product use number two   => 2       |");
                System.out.println("| if you want to create a client use number three   => 3      |");
                System.out.println("| if you want to sale some product use number four   => 4     |");
                System.out.println("| if you want to see all transactions use number five => 5    |");
                System.out.println("| if you want to see all product use number six        => 6   |");
                System.out.println("| if you want to see all client use number seven        => 7  |");
                System.out.println("| if you want to close the application use number zero   => 0 |");

                System.out.println("***************************************************************");
                System.out.print("you have to choose one of this : ");


                Scanner scanner = new Scanner(System.in).useDelimiter("\n");
                choose = scanner.nextInt();


                switch (choose) {

                    case 1: {
                        Product product = new Product();
                        System.out.println("product name :");
                        product.setName(scanner.next());
                        System.out.println("product price :");
                        product.setPrice(scanner.nextInt());
                        System.out.println("product Quantity :");
                        product.setQuantity(scanner.nextInt());

                        listProduct.add(product);
                        System.out.println("************************************");
                        System.out.println("product created successfully");
                        System.out.println("************************************");


                    }
                    break;

                    case 2: {

                        System.out.println("product name :");
                        String updatedData = scanner.next();
                        Product findProduct = listProduct
                                .stream()
                                .filter(produit -> produit.getName().equals(updatedData))
                                .findFirst().orElseThrow(() -> new ProductNotFoundExeption("Product not found exception"));
                        System.out.println("write the new price");
                        findProduct.setPrice(scanner.nextInt());
                        System.out.println("write the new Quantity");
                        findProduct.setQuantity(scanner.nextInt());
                        listProduct.set(listProduct.indexOf(findProduct), findProduct);
                        System.out.println("************************************");
                        System.out.println("product updated successfully");
                        System.out.println("************************************");


                    }
                    break;

                    case 3:
                    {
                        Client client = new Client();
                        System.out.println("client name");
                        String clientName = scanner.next();
                        client.setName(clientName);

                        listClient.add(client);
                        System.out.println("************************************");
                        System.out.println("client created successfully");
                        System.out.println("************************************");


                    }
                    break;

                    case 4:
                    {
                        Sale sale = new Sale();
                        System.out.println("Product name :");
                        String findProduct = scanner.next();
                        Product selectedProduct = listProduct
                                .stream()
                                .filter(produit -> produit.getName().equals(findProduct))
                                .findFirst()
                                .orElseThrow(() -> new ProductNotFoundExeption("product not found exception"));
                        sale.setProduct(selectedProduct.getName());

                        System.out.println("client name :");
                        String clientName = scanner.next();
                        Client selectedClient = listClient
                                .stream()
                                .filter(client -> client.getName().equals(clientName))
                                .findFirst()
                                .orElseThrow(() -> new ClientNotFoundException("client not found exception"));
                        sale.setClient(selectedClient.getName());
                        System.out.println("how many Product you want ?");
                        int quantity =  scanner.nextInt();
                        if(selectedProduct.getQuantity() > quantity){
                            sale.setQuantity(quantity);
                        }
                        else throw new QuantityNotAvailable("Quantity Not Available");
                        selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity);
                        listProduct.set(listProduct.indexOf(selectedProduct) ,selectedProduct);
                        sale.setTotalPrice(selectedProduct.getPrice() * quantity);
                        listSale.add(sale);
                        System.out.println("************************************");
                        System.out.println("successfully");
                        System.out.println("************************************");

                        BufferedWriter writerVente = new BufferedWriter(new FileWriter(sale_db, true));
                            writerVente.write("id:"+ sale.getId());
                            writerVente.newLine();
                            writerVente.write("client:" +sale.getClient());
                            writerVente.newLine();
                            writerVente.write("product:" +sale.getProduct());
                            writerVente.newLine();
                            writerVente.write("Quantity:" +sale.getQuantity());
                            writerVente.newLine();
                            writerVente.write("Total price:" +sale.getTotalPrice());
                            writerVente.newLine();
                            writerVente.write("***********************************");
                            writerVente.newLine();



                        writerVente.close();





                    }
                    break;

                    case 5:
                    {
                        System.out.println();
                        System.out.println("list of transaction");
                        System.out.println("⇩⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⇩");

                        BufferedReader readeInSale = new BufferedReader(new FileReader(sale_db));
                        readeInSale.lines().collect(Collectors.toList()).forEach(list ->{
                            System.out.println(list);
                        });
                        readeInSale.close();


                    }
                    break;

                    case 6:
                    {
                        System.out.println();
                        System.out.println("list of product");
                        System.out.println("⇩⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⇩");
                        for(Product produit: listProduct){

                            System.out.println("id:"+ produit.getId());

                            System.out.println("name:" +produit.getName());

                            System.out.println("price:" + produit.getPrice());

                            System.out.println("quantity:"+ produit.getQuantity());

                            System.out.println("***********************************");


                        }



                    }
                    break;

                    case 7:
                    {
                        System.out.println();
                        System.out.println("list of client");
                        System.out.println("⇩⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⇩");
                        for(Client client: listClient){

                            System.out.println("id:"+ client.getId());

                            System.out.println("name:" +client.getName());

                            System.out.println("***********************************");


                        }




                    }
                    break;




                }


                if (choose == 0) {


                    BufferedWriter writerProduit = new BufferedWriter(new FileWriter(product_db));

                    for(Product produit: listProduct){

                        writerProduit.write("id:"+ produit.getId());
                        writerProduit.newLine();
                        writerProduit.write("name:" +produit.getName());
                        writerProduit.newLine();
                        writerProduit.write("price:" +(int)produit.getPrice());
                        writerProduit.newLine();
                        writerProduit.write("quantity:"+produit.getQuantity());
                        writerProduit.newLine();
                        writerProduit.write("***********************************");
                        writerProduit.newLine();

                    }

                    writerProduit.close();

                    BufferedWriter writerClient = new BufferedWriter(new FileWriter(client_db));
                    for (Client client : listClient){
                        writerClient.write("id:"+ client.getId());
                        writerClient.newLine();
                        writerClient.write("name:" +client.getName());
                        writerClient.newLine();
                        writerClient.write("***********************************");
                        writerClient.newLine();
                    }


                    writerClient.close();


                }


            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }while (choose != 0);


    }

}
