package com.AddTwoFractions;

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
                int[] numbers = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                int[] number1 = {numbers[0],numbers[1]};
                int[] number2 = {numbers[2],numbers[3]};

                int[] answer = {number1[0]*number2[1]+number2[0]*number1[1], number1[1]*number2[1]};


                int divider = findGCD(answer[0],answer[1]);
                StringBuilder answerStr = new StringBuilder();
                for (int i = 0; i < answer.length; i++) {
                    answerStr.append(answer[i]/divider);
                    answerStr.append(" ");

                }
                answerStr.setLength(answerStr.length() - 1);
                System.out.println(answerStr);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }
}


