package xyz.codingmentor.team3.registry.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author Daróczi Kristóf
 */
@ApplicationException(rollback = false)
public class RepositoryException extends Exception {

    public RepositoryException() {
        //empty on purpose
    }

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }

    public RepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
