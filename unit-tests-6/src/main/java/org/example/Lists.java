package org.example;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Lists {
    List<Integer> list1;
    List<Integer> list2;

    public Lists(String s, Path path) {
        list1 = Utils.getListFromString(s);
        list2 = Utils.getListFromFile(path);
    }

    public static double getAverageFromList(List<Integer> numbers) {
        int sum = 0;
        for (Integer i : numbers) {
            sum += i;
        }
        return (double) sum / numbers.size();
    }

    public static void getMaxAverage(List<Integer> list1, List<Integer> list2) {
        double avg1 = getAverageFromList(list1);
        double avg2 = getAverageFromList(list2);
        if (avg1 > avg2) {
            System.out.println("Первый список имеет большее среднее значение");
        } else if (avg1 < avg2) {
            System.out.println("Второй список имеет большее среднее значение");
        } else {
            System.out.println("Средние значения равны");
        }
    }
}
