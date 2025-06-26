package UserApp.utils;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.List;

public class XMLUtils {

    @XmlRootElement(name = "users")
    public static class UserListWrapper {
        private List<User> users;

        @XmlElement(name = "user")
        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }
    }

    public static void exportUsers(List<User> users, File file) throws Exception {
        JAXBContext context = JAXBContext.newInstance(UserListWrapper.class, User.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        UserListWrapper wrapper = new UserListWrapper();
        wrapper.setUsers(users);

        marshaller.marshal(wrapper, file);
    }

    public static List<User> importUsers(File file) throws Exception {
        JAXBContext context = JAXBContext.newInstance(UserListWrapper.class, User.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        UserListWrapper wrapper = (UserListWrapper) unmarshaller.unmarshal(file);
        return wrapper.getUsers();
    }
}
