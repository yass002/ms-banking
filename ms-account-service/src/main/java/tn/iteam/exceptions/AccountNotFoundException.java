package tn.iteam.exceptions;


public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String string) {
        super(string);
    }
}
