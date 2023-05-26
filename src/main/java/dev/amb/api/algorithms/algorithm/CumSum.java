package dev.amb.api.algorithms.algorithm;

import java.util.ArrayList;
import java.util.List;

public class CumSum {
    public static String exec(String value) {
        value = value.trim();
        List<Integer> input = inputHandler(value);
        int result = cumSum(input);
        return String.valueOf(result);
    }

    private static List<Integer> inputHandler(String input) {
        String[] arrNum = input.split(" ");
        List<Integer> arrInt = new ArrayList<>();
        for (String num : arrNum) {
            arrInt.add(Integer.parseInt(num));
        }
        return arrInt;
    }

    private static int cumSum(List<Integer> arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
