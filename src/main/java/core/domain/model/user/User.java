package core.domain.model.user;

import core.domain.model.NamedEntity;

import java.util.Set;

public class User extends NamedEntity {

    private String login;
    private String password;
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
