package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MainHWTest {
    MainHW mainHW;

    @BeforeEach
    void setup() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {-2044, -2, 4, 18, 1112, 398_945_002})
    void evenOddNumberIsEvenReturnsTrue(int n) {
        assertThat(mainHW.evenOddNumber(n)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {- 593, -9, 1, 5, 2_091_117})
    void evenOddNumberIsOddReturnsFalse(int n) {
        assertThat(mainHW.evenOddNumber(n)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-12, 0, 24, 25, 100, 101, 1984})
    void numberInIntervalReturnsFalse(int n) {
        assertThat(mainHW.numberInInterval(n)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 39, 57, 84, 99})
    void numberInIntervalReturnsTrue(int n) {
        assertThat(mainHW.numberInInterval(n)).isTrue();
    }
}