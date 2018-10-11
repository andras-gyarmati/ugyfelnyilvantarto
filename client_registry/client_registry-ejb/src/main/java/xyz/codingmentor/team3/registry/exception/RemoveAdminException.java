package xyz.codingmentor.team3.registry.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author Tibor Kun
 */
@ApplicationException(rollback = false)
public class RemoveAdminException extends RuntimeException {

    public RemoveAdminException(String message) {
        super(message);
    }

}
