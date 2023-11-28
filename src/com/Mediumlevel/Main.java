package com.Mediumlevel;

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

                int n =Integer.parseInt(line);

                line = br.readLine();

                int[] numbers = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int[] answer = new int[numbers.length];
                int rightSum = Arrays.stream(numbers).sum();
                int leftSum = 0;


                for (int i = 0; i < numbers.length; i++) {
                        answer[i] = i*numbers[i]-leftSum+rightSum-(n-i)*numbers[i];
                        leftSum +=numbers[i];
                        rightSum -=numbers[i];
                }

                System.out.println(Arrays.toString(answer).replaceAll("[\\[\\],]", ""));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
