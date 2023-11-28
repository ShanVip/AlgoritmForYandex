package com.NotAtLeastOnTheStretch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        File file = new File("input.txt");
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                line = br.readLine();
                int[] numbers = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int n = numbers[0];
                int m = numbers[1];
                line = br.readLine();
                int[] array = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int i = 0; i < m; i++) {
                    line = br.readLine();
                    int[] counting = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    int start = counting[0];
                    int end = counting[1];
                    Set<Integer> set = new HashSet<>();
                    start = Math.max(start, 0);
                    end = Math.min(end, array.length);
                    for (int j = start; j <= end ; j++) {
                        set.add(array[j]);
                    }
                    if (set.size() <= 1) {
                        System.out.println("NOT FOUND");
                    } else {
                        int maxValue = set.stream()
                                .mapToInt(Integer::intValue)
                                .max()
                                .getAsInt();
                        System.out.println(maxValue);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
