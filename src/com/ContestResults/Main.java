package com.ContestResults;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                line = br.readLine();
                int a = Integer.parseInt(line);
                line = br.readLine();
                int b = Integer.parseInt(line);
                line = br.readLine();
                int c = Integer.parseInt(line);

               if (a/1 > Math.ceil((double) b/c)){
                   System.out.println("Yes");
               } else System.out.println("No");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}