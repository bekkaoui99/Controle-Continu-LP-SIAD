package ma.java.exception;

public class ProductNotFoundExeption extends RuntimeException{

    public ProductNotFoundExeption(String msg){
        super(msg);
    }
}
