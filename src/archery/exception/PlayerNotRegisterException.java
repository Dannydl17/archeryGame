package archery.exception;

public class PlayerNotRegisterException extends RuntimeException{
    public PlayerNotRegisterException(String message){
        super(message);
    }
}
