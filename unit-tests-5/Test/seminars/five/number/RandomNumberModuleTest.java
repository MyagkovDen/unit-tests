package seminars.five.number;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberModuleTest {

    @Test
    void createListInteger(){
        List<Integer> nums  = RandomNumberModule.createListInteger(5);

        assertThat(!nums.isEmpty()).isTrue();
        assertThat(nums).hasSize(5);
       // assertThat(nums).isNotEmpty().hasSize(5);
    }

}