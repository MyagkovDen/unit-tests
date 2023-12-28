package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public List<User> getData() {
        return data;
    }

    public void addUser(User user) {
        if (user.isAuthenticate) {
            data.add(user);
        }
    }

    public void logoutAll() {
        data.removeIf(user -> !user.isAdmin());
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }
}