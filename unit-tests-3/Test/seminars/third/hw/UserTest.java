package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    User user;
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        user = new User("user", "password");
        userRepository = new UserRepository();
    }

    @Test
    void loginTrue() {
        assertTrue(user.login("user", "password"));
    }

    @ParameterizedTest
    @CsvSource({"root, 1234", "root, password", "user, 1234"})
    void loginFalse(String name, String password) {
        assertFalse(user.login(name, password));
    }

    @Test
    void addUserTrue() {
        user.login(user.name, user.password);
        userRepository.addUser(user);
        assertTrue(userRepository.findByName("user"));
    }

    @Test
    void addUserFalse() {
        User newUser = new User("Ivan", "1111");
        userRepository.addUser(newUser);
        assertFalse(userRepository.findByName("ivan"));
    }

    @Test
    void logoutAll() {
        User user1 = new User("Petr", "123");
        User user2 = new User("Ivan", "321", true);
        user.login(user.name, user.password);
        userRepository.addUser(user);
        user1.login(user1.name, user1.password);
        userRepository.addUser(user1);
        user2.login(user2.name, user2.password);
        userRepository.addUser(user2);
        userRepository.logoutAll();
        assertThat(userRepository.getData()).hasSize(1)
                .contains(user2)
                .doesNotContain(user, user1);
    }
}
