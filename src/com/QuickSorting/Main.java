package com.QuickSorting;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                line = br.readLine();
                int a = Integer.parseInt(line);
                int[] numbers = new int[a];
                if (a == 0) {
                    System.out.println("");
                }

                if (a > 0) {
                    line = br.readLine();
                    numbers = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    quickSort(numbers, 0, numbers.length - 1);
                    for (int num : numbers) {
                        System.out.print(num + " ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
