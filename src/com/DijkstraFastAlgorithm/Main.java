package com.DijkstraFastAlgorithm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] line = reader.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);

            List<int[]>[] graph = new List[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                line = reader.readLine().split(" ");
                int a = Integer.parseInt(line[0]) - 1;
                int b = Integer.parseInt(line[1]) - 1;
                int l = Integer.parseInt(line[2]);
                graph[a].add(new int[]{b, l});
                graph[b].add(new int[]{a, l});
            }

            line = reader.readLine().split(" ");
            int A = Integer.parseInt(line[0]) - 1;
            int B = Integer.parseInt(line[1]) - 1;

            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[A] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.add(new int[]{A, 0});

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int u = current[0];
                int currentDist = current[1];

                if (currentDist > dist[u]) {
                    continue;
                }

                for (int[] edge : graph[u]) {
                    int v = edge[0];
                    int weight = edge[1];
                    int newDist = currentDist + weight;
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new int[]{v, newDist});
                    }
                }
            }

            if (dist[B] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dist[B]);
            }

        } catch (IOException e) {
            System.err.println("Ошибка при открытии или чтении файла ввода.");
        }
    }
}

