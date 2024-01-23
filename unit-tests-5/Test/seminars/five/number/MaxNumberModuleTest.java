package seminars.five.number;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MaxNumberModuleTest {

    @Test
    void getMax() {
        List<Integer> list  = List.of(1,2,3,4,5);
       // new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int n = 5;

        assertThat(MaxNumberModule.getMax(list)).isEqualTo(5);
    }

    @Test
    void getMaxRandom(){
        List <Integer> list = RandomNumberModule.createListInteger(10);
        int n = Collections.max(list);

        assertThat(MaxNumberModule.getMax(list)).isEqualTo(n);
    }
}