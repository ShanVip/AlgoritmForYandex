package com.DijkstraWithPathRestoration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] inputLine = reader.readLine().split(" ");
            int N = Integer.parseInt(inputLine[0]);
            int S = Integer.parseInt(inputLine[1]) - 1; // Subtract 1 to make it 0-based
            int F = Integer.parseInt(inputLine[2]) - 1; // Subtract 1 to make it 0-based

            int[][] graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(row[j]);
                }
            }

            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[S] = 0;

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(v -> dist[v]));
            priorityQueue.add(S);

            int[] parent = new int[N];
            Arrays.fill(parent, -1);

            while (!priorityQueue.isEmpty()) {
                int u = priorityQueue.poll();
                if (u == F) break;

                for (int v = 0; v < N; v++) {
                    if (graph[u][v] >= 0) {
                        int newDist = dist[u] + graph[u][v];
                        if (newDist < dist[v]) {
                            dist[v] = newDist;
                            parent[v] = u;
                            priorityQueue.add(v);
                        }
                    }
                }
            }

            if (dist[F] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                List<Integer> shortestPath = new ArrayList<>();
                int currentVertex = F;
                while (currentVertex != S) {
                    shortestPath.add(currentVertex + 1); // Add 1 to make it 1-based
                    currentVertex = parent[currentVertex];
                }
                shortestPath.add(S + 1); // Add 1 to make it 1-based
                Collections.reverse(shortestPath);
                for (int vertex : shortestPath) {
                    System.out.print(vertex + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


