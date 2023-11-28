package com.LostWorld;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            int N = scanner.nextInt();
            scanner.close();

            long result = countWaysToArrangeDinosaurs(N);

            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static long countWaysToArrangeDinosaurs(int N) {
        if (N == 1) {
            return 1;
        }

        long result = 0;

        for (int i = 0; i < N; i++) {
            result += countWaysForRemainingDinosaurs(N, 1, i, new boolean[N][N]);
        }

        return result;
    }

    private static long countWaysForRemainingDinosaurs(int N, int row, int col, boolean[][] attacked) {
        if (row == N) {
            return 1;
        }

        attacked[row][col] = true;

        long result = 0;

        for (int nextCol = 0; nextCol < N; nextCol++) {
            if (!isAttacked(row + 1, nextCol, attacked)) {
                result += countWaysForRemainingDinosaurs(N, row + 1, nextCol, attacked);
            }
        }

        attacked[row][col] = false;

        return result;
    }

    private static boolean isAttacked(int row, int col, boolean[][] attacked) {
        for (int i = 0; i < row; i++) {
            if (attacked[i][col] || (col - (row - i) >= 0 && attacked[i][col - (row - i)]) || (col + (row - i) < attacked.length && attacked[i][col + (row - i)])) {
                return true;
            }
        }
        return false;
    }
}

