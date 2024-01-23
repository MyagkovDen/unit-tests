package seminars.five.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void getUserName(int n) {
        UserRepository repository = new UserRepository();
        UserService service = new UserService(repository);
        String result = service.getUserName(n);

        assertThat(result).isEqualTo("User " + n);
    }
}