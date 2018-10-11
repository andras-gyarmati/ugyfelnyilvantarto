package xyz.codingmentor.team3.registry.dto.contactperson;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import xyz.codingmentor.team3.registry.dto.person.PersonDTO;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Validate
public class ContactPersonDTO extends PersonDTO implements Serializable {

    @NotNull
    private Long clientId;

    public ContactPersonDTO() {
        // nothing to initialize
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return super.toString() + "\nclientId=" + clientId;
    }

}
