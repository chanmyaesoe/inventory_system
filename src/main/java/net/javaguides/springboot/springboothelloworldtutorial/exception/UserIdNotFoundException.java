package net.javaguides.springboot.springboothelloworldtutorial.exception;

public class UserIdNotFoundException extends RuntimeException{
    public UserIdNotFoundException()
    {
        super("User Id Not Found");
    }
}