package com.Rabbit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] garden = new int[n][m];


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    garden[i][j] = scanner.nextInt();
                }
            }

            int[][] dp = new int[n][m];


            for (int i = 0; i < n; i++) {
                dp[i][0] = garden[i][0];
            }
            for (int j = 0; j < m; j++) {
                dp[0][j] = garden[0][j];
            }


            int maxSize = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (garden[i][j] == 1) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        maxSize = Math.max(maxSize, dp[i][j]);
                    }
                }
            }

            System.out.println(maxSize);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}







