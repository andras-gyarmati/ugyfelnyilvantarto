package xyz.codingmentor.team3.registry.entity.role;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author Tibor Kun
 */
@Entity
@Validate
@Table(name = "role_table")
@NamedQueries({
    @NamedQuery(name = "Role.getAll", query = "FROM Role r"),
    @NamedQuery(name = "Role.count", query = "SELECT COUNT(r) FROM Role r")})
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    @NotNull
    private RoleType roleType;

    public Role() {
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

}
