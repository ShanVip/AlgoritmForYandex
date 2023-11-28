package com.SequenceMerging;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int stopIndex = Integer.parseInt(reader.readLine());
            int counter = 0;
            int answer = 1;
            int l = 1;
            int r = 1;

            while (true) {
                if (counter == stopIndex) {
                    break;
                }
                counter++;
                if (l * l == r * r * r) {
                    answer = l * l;
                    l++;
                    r++;
                    continue;
                }
                if (l * l > r * r * r) {
                    answer = r * r * r;
                    r++;
                    continue;
                }
                if (l * l < r * r * r) {
                    answer = l * l;
                    l++;
                    continue;
                }
            }

            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

