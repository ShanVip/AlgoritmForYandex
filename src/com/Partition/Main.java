package com.Partition;

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
                if (a==0){
                    System.out.println(0);
                    System.out.println(0);
                }else {
                    line = br.readLine();
                    int[] numbers = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    line = br.readLine();
                    int num = Integer.parseInt(line);
                    int counter = 0;
                    for (int i = 0; i < numbers.length; i++) {
                        if(num>numbers[i]){
                            counter++;
                        }

                    }
                    System.out.println(counter);
                    System.out.println(numbers.length-counter);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}