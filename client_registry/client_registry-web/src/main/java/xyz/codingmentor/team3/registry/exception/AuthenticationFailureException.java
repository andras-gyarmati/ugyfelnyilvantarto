package xyz.codingmentor.team3.registry.exception;

/**
 *
 * @author brianelete
 */
public class AuthenticationFailureException extends Exception {

    public AuthenticationFailureException() {
        // nothing to initialize
    }

    public AuthenticationFailureException(String message) {
        super(message);
    }

}
