package ma.java.exception;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(String msg){
        super(msg);
    }

}
