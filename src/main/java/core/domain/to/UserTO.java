package core.domain.to;

public class UserTO extends BaseTO{
    private String name;
    private String login;
    private String password;

    public UserTO() {
    }

    public UserTO(Integer id, String name, String login, String password) {
        super(id);
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "UserTO{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
