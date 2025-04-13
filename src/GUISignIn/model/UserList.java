package GUISignIn.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
public class UserList {
    private List<UserConfig> users;

    public UserList() {

    }

    public UserList(List<UserConfig> users) {
        this.users = users;
    }

    @XmlElement(name = "user")
    public List<UserConfig> getUsers() {
        return users;
    }

    public void setUsers(List<UserConfig> users) {
        this.users = users;
    }
}

