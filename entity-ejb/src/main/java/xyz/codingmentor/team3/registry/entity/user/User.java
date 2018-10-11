package xyz.codingmentor.team3.registry.entity.user;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import xyz.codingmentor.team3.registry.entity.person.Person;
import xyz.codingmentor.team3.registry.entity.role.Role;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author Tibor Kun
 */
@Entity
@Validate
@Table(name = "user_table")
@DiscriminatorValue("U")
@NamedQueries({
    @NamedQuery(name = "User.getAll", query = "FROM User u"),
    @NamedQuery(name = "User.count", query = "SELECT COUNT(u) FROM User u")})
public class User extends Person implements Serializable {

    @NotNull
    @Size(message = "Too short username", min = 5)
    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_groups",
            joinColumns = @JoinColumn(name = "user_fk"),
            inverseJoinColumns = @JoinColumn(name = "role_fk"))
    private List<Role> roles;

    public User() {
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

    @XmlTransient
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
