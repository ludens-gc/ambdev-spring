package dev.amb.api.algorithms.algorithm;

import java.util.ArrayList;
import java.util.List;

public class CountInt {
    public static String exec(String value) {
        value = value.trim();
        List<Double> input = inputHandler(value);
        int result = countInt(input);
        return String.valueOf(result);
    }

    private static List<Double> inputHandler(String input) {
        String[] arrNum = input.split(" ");
        List<Double> arrDouble = new ArrayList<>();
        for (String num : arrNum) {
            arrDouble.add(Double.parseDouble(num));
        }
        return arrDouble;
    }

    private static int countInt(List<Double> arr) {
        int count = 0;
        for (double num : arr) {
            if (isInteger(num)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isInteger(double num) {
        return num == (int) num;
    }
}
