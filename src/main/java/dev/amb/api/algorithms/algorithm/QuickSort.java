package dev.amb.api.algorithms.algorithm;

import java.util.ArrayList;

public class QuickSort {
    public static String exec(String value) {
        value = value.trim();
        ArrayList<Integer> input = inputHandler(value);
        ArrayList<Integer> funcResult = quickSort(input);
        String result = showList(funcResult);
        return result;
    }

    private static ArrayList<Integer> inputHandler(String input) {
        String[] inputArray = input.split(" ");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (String num : inputArray) {
            arr.add(Integer.parseInt(num));
        }
        return arr;
    }

    private static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }

        int pivot = arr.get(0);
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < pivot) {
                left.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }

        ArrayList<Integer> sortedLeft = quickSort(left);
        ArrayList<Integer> sortedRight = quickSort(right);

        ArrayList<Integer> sortedArr = new ArrayList<Integer>();
        sortedArr.addAll(sortedLeft);
        sortedArr.add(pivot);
        sortedArr.addAll(sortedRight);

        return sortedArr;
    }

    private static String showList(ArrayList<Integer> arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
            if (i < arr.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
