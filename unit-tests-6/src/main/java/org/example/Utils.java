package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utils {
    private Utils() {
    }

    static List<Integer> getListFromString(String s) {
        String[] input = s.split(", ");
        Integer[] array = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        return Arrays.asList(array);
    }

    static List<Integer> getListFromFile(Path path) {
        try (InputStream inputStream = Files.newInputStream(path);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String s = bufferedReader.readLine();
            return getListFromString(s);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
