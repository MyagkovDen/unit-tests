package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void getListFromString() {
        String s = "1, 2, 3, 4";
        List<Integer> list = Utils.getListFromString(s);

        assertThat(list).isEqualTo(List.of(1, 2, 3, 4));
    }

    @Test
    void getListFromFile_ValidPath() {
        Path path = Path.of("inputData");
        List<Integer> list = Utils.getListFromFile(path);

        assertThat(list).isEqualTo(List.of(1, 3, 5, 7));
    }

    @Test
    void getListFromFile_InvalidPath() {
        Path path = Path.of("inputdata");
        List<Integer> list = Utils.getListFromFile(path);

        assertThat(list).isEqualTo(new ArrayList<Integer>());
    }
}