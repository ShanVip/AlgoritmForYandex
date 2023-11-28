package com.MaximumCut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            int N = scanner.nextInt();
            int[][] adjacencyMatrix = new int[N][N];

            // Чтение матрицы смежности из файла
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    adjacencyMatrix[i][j] = scanner.nextInt();
                }
            }

            // Решение задачи
            int[] partitions = maximizeWeight(adjacencyMatrix, N);

            // Вывод результата
            System.out.println(calculateWeight(adjacencyMatrix, partitions));
            for (int i : partitions) {
                System.out.print(i + " ");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int[] maximizeWeight(int[][] adjacencyMatrix, int N) {
        int[] partitions = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(adjacencyMatrix, N, i, partitions, visited);
            }
        }

        return partitions;
    }

    private static void dfs(int[][] adjacencyMatrix, int N, int vertex, int[] partitions, boolean[] visited) {
        visited[vertex] = true;

        for (int i = 0; i < N; i++) {
            if (adjacencyMatrix[vertex][i] > 0 && !visited[i]) {
                partitions[i] = 3 - partitions[vertex];
                dfs(adjacencyMatrix, N, i, partitions, visited);
            }
        }
    }

    private static int calculateWeight(int[][] adjacencyMatrix, int[] partitions) {
        int weight = 0;

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = i + 1; j < adjacencyMatrix[0].length; j++) {
                if (adjacencyMatrix[i][j] > 0 && partitions[i] != partitions[j]) {
                    weight += adjacencyMatrix[i][j];
                }
            }
        }

        return weight;
    }
}
