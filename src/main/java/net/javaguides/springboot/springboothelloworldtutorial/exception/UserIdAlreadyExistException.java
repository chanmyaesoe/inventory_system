package net.javaguides.springboot.springboothelloworldtutorial.exception;

public class UserIdAlreadyExistException extends RuntimeException{
    public UserIdAlreadyExistException() {
        super("User Id Already Exist");
    }
}
