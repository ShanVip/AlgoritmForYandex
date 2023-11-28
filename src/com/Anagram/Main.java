package com.Anagram;

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
                char[] str1 = line.toCharArray();
                line = br.readLine();
                char[] str2 = line.toCharArray();

                Arrays.sort(str1);
                Arrays.sort(str2);

                if (Arrays.equals(str1, str2)){
                    System.out.println("YES");
                } else System.out.println("NO");


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
