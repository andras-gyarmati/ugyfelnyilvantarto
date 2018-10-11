package xyz.codingmentor.team3.registry.dto.role;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import xyz.codingmentor.team3.registry.entity.role.RoleType;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Validate
public class RoleDTO implements Serializable {

    private Long id;

    @NotNull
    private RoleType roleType;

    public RoleDTO() {
        // nothing to initialize
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "\nid=" + id + "\nroleType=" + roleType;
    }

}
