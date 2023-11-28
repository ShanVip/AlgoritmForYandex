package com.Dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());

            int[][] graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (graph[i][k] != -1 && graph[k][j] != -1) {
                            if (graph[i][j] == -1 || graph[i][j] > graph[i][k] + graph[k][j]) {
                                graph[i][j] = graph[i][k] + graph[k][j];
                            }
                        }
                    }
                }
            }

            int shortestDistance = graph[S - 1][F - 1];
            if (shortestDistance == -1) {
                System.out.println(-1);
            } else {
                System.out.println(shortestDistance);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
