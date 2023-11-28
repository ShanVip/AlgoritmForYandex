package com.Merger;

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

                if (a==0){

                  line= br.readLine();

                } else {
                    line = br.readLine();
                    numbers = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                }

                line = br.readLine();
                int b = Integer.parseInt(line);

                int[] numbers2 = new int[b];

                if (b==0){
                    line= br.readLine();

                } else {
                    line = br.readLine();
                    numbers2 = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                }




                if (b==0 || a==0){
                    if (b == 0){
                        Arrays.sort(numbers);
                        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
                    } else Arrays.sort(numbers2);
                           System.out.println(Arrays.toString(numbers2).replaceAll("[\\[\\],]", ""));
                } else {
                    int[] result = mergeArrays(numbers, numbers2);
                    System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
                }



            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int N = arr1.length;
        int M = arr2.length;
        int[] result = new int[N + M];

        int i = 0, j = 0, k = 0;

        while (i < N && j < M) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < N) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < M) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }
}