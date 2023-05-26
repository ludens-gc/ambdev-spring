package dev.amb.api.algorithms.algorithm;

import java.util.ArrayList;
import java.util.List;

public class GCDCalculator {
    public static String exec(String value) {
        value = value.trim();
        List<Integer> input = inputHandler(value);
        int numX = input.get(0);
        int numY = input.get(1);
        int result = gcd(numX, numY);
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

    private static int gcd(int numX, int numY) {
        if (numY == 0) {
            return numX;
        }
        return gcd(numY, numX % numY);
    }
}
