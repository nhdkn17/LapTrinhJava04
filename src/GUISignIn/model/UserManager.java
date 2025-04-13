package GUISignIn.model;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<UserConfig> userList = new ArrayList<>();

    public boolean register(String username, String password) {
        for (UserConfig u : userList) {
            if (u.getUsername().equals(username)) return false;
        }
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        userList.add(new UserConfig(username, hashed));
        return true;
    }

    public boolean login(String username, String password) {
        for (UserConfig u : userList) {
            if (u.getUsername().equals(username) &&
                    BCrypt.checkpw(password, u.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public List<UserConfig> getUsers() {
        return userList;
    }

    public void exportToXML(File file) throws Exception {
        UserList wrapper = new UserList(userList);
        JAXBContext context = JAXBContext.newInstance(UserList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(wrapper, file);
    }

    public void importFromXML(File file) throws Exception {
        JAXBContext context = JAXBContext.newInstance(UserList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        UserList wrapper = (UserList) unmarshaller.unmarshal(file);
        userList = wrapper.getUsers();
    }
}
