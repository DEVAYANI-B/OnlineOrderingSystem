package main.java.com.examly.Exception;

public class EmailAlreadyExistsException extends Exception{
    public EmailAlreadyExistsException(String message){
        super(message);
    }
}