package xyz.codingmentor.team3.registry.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author Tibor Kun
 */
@ApplicationException(rollback = false)
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }

}
