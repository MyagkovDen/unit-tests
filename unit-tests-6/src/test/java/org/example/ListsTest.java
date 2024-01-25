package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
 class ListsTest  {

    @Test
    void Lists(){
        String s = "7, 5, 4, 3";
        Path path = Path.of("inputData");
        Lists lists = new Lists(s, path);

        assertThat(Utils.getListFromString(s)).isEqualTo(lists.list1);
        assertThat(Utils.getListFromFile(path)).isEqualTo(lists.list2);
    }

    @Test
    void testGetAverageFromList() {
        List<Integer> list = Arrays.asList(1,2,3);
        int avg = 2;

        assertThat(Lists.getAverageFromList(list)).isEqualTo(avg);
    }

    @Test
    void testGetMaxAverage_SecondAverageGreater() {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(2,4,6);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Lists.getMaxAverage(list1, list2);
        String output = outputStream.toString();

        assertThat(output).isEqualTo("Второй список имеет большее среднее значение\n");
    }

    @Test
    void testGetMaxAverage_FirstAverageGreater() {
        List<Integer> list1 = Arrays.asList(2,4,6);
        List<Integer> list2 = Arrays.asList(1,2,3);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Lists.getMaxAverage(list1, list2);
        String output = outputStream.toString();

        assertThat(output).isEqualTo("Первый список имеет большее среднее значение\n");
    }

    @Test
    void testGetMaxAverage_AveragesEquals() {
        List<Integer> list1 = Arrays.asList(2,4,6);
        List<Integer> list2 = Arrays.asList(6,4,2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Lists.getMaxAverage(list1, list2);
        String output = outputStream.toString();

        assertThat(output).isEqualTo("Средние значения равны\n");
    }
}