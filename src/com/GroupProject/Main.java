package com.GroupProject;

import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                line = br.readLine();
                int n = Integer.parseInt(line);

                for (int i = 0; i < n; i++) {
                    line = br.readLine();
                    int[] numbers = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    int difference = numbers[2] - numbers[1];
                    int check = numbers[0]/numbers[1];
                    if (check*numbers[1]+difference*check>=numbers[0]){
                        System.out.println("YES");
                    } else System.out.println("NO");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
