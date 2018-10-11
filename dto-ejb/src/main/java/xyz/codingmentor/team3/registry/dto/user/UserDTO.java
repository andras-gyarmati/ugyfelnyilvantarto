package xyz.codingmentor.team3.registry.dto.user;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.team3.registry.constraints.Password;
import xyz.codingmentor.team3.registry.dto.person.PersonDTO;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Validate
public class UserDTO extends PersonDTO implements Serializable {

    @NotNull
    @Size(message = "Too short username", min = 5)
    private String username;

    @Password
    private String password;

    private List<Long> roleIdList;

    public UserDTO() {
        // nothing to initialize
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nusername: " + username
                + "\npassword: " + password
                + "\nroleIdList: " + roleIdList;
    }

}
