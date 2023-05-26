package dev.amb.api.algorithms.algorithm;

public class IsPrime {
    public static String exec(String value) {
        value = value.trim();
        int input = inputHandler(value);
        boolean funcResult = isPrime(input);
        String result = funcResult ? "true" : "false";
        return result;
    }

    private static int inputHandler(String input) {
        int num = Integer.parseInt(input);
        return num;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
