package dev.amb.api.algorithms.algorithm;

import java.util.List;
import java.util.ArrayList;

public class Fibonacci {
    public static String exec(String value) {
        value = value.trim();
        int input = inputHandler(value);
        List<Integer> result = fibonacci(input);
        return showFibonacci(result);
    }

    private static int inputHandler(String input) {
        int num = Integer.parseInt(input);
        return num;
    }

    private static List<Integer> fibonacci(int num) {
        List<Integer> seq = new ArrayList<>();
        if (num <= 0) {
            return seq;
        } else if (num == 1) {
            seq.add(0);
        } else if (num >= 2) {
            seq.add(0);
            seq.add(1);
            for (int i = 2; i < num; i++) {
                seq.add(seq.get(i - 1) + seq.get(i - 2));
            }
        }
        return seq;
    }

    private static String showFibonacci(List<Integer> seq) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seq.size(); i++) {
            sb.append(seq.get(i));
            if (i < seq.size() - 1) {
                sb.append(" ");
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}
