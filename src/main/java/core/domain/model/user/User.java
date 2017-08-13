package core.domain.model.user;

import core.domain.model.NamedEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends NamedEntity {

    @NotBlank
    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Length(min = 5)
    @NotBlank
    @Column(name = "password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role")
    private Set<Role> roles;

    public User() {
    }

    public User(Integer id, String name, String login, String password, Set<Role> roles) {
        super(id, name);
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
