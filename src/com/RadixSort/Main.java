package com.RadixSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            int n = Integer.parseInt(br.readLine());

            ArrayList<String> initialArray = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                initialArray.add(br.readLine());
            }

            int m = initialArray.get(0).length();

            System.out.println("Initial array:");
            printArray(initialArray);

            for (int i = m - 1; i >= 0; i--) {
                System.out.println("**********");
                System.out.println("Phase " + (m - i));

                ArrayList<ArrayList<String>> buckets = new ArrayList<>();
                for (int j = 0; j <= 9; j++) {
                    buckets.add(new ArrayList<>());
                }

                for (String s : initialArray) {
                    int digit = Character.getNumericValue(s.charAt(i));
                    buckets.get(digit).add(s);
                }

                for (int j = 0; j <= 9; j++) {
                    if (!buckets.get(j).isEmpty()) {
                        System.out.println("Bucket " + j + ": " + String.join(", ", buckets.get(j)));
                    } else {
                        System.out.println("Bucket " + j + ": " + "empty");
                    }
                }

                initialArray.clear();
                for (ArrayList<String> bucket : buckets) {
                    initialArray.addAll(bucket);
                }


            }
            System.out.println("**********");
            System.out.println("Sorted array:");
            printArray(initialArray);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printArray(ArrayList<String> array) {
        System.out.println(String.join(", ", array));
    }
}