package com.Relocation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static Map<Integer, Integer> dijkstra(Map<Integer, Map<Integer, int[]>> graph, int start, int currentWeight) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (int vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, start});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentDistance = current[0];
            int currentVertex = current[1];

            if (currentDistance > distances.get(currentVertex)) {
                continue;
            }

            for (Map.Entry<Integer, int[]> entry : graph.get(currentVertex).entrySet()) {
                int neighbor = entry.getKey();
                int[] edge = entry.getValue();
                int distance = currentDistance + edge[0];

                if (distance < distances.get(neighbor)) {
                    distances.put(neighbor, distance);
                    queue.offer(new int[]{distance, neighbor});
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        if (N == 1) {
            System.out.println(10000000);
            return;
        }

        Map<Integer, Map<Integer, int[]>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashMap<>());
        }

        int maxWeight = 3000000;
        Set<Integer> uniqueWeights = new HashSet<>();

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int t = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());

            if (w <= maxWeight) {
                continue;
            }

            graph.get(a).put(b, new int[]{t, w});
            graph.get(b).put(a, new int[]{t, w});
            uniqueWeights.add(w);
        }

        List<Integer> sortedUniqueWeights = new ArrayList<>(uniqueWeights);
        Collections.sort(sortedUniqueWeights, Collections.reverseOrder());

        for (int currentWeight : sortedUniqueWeights) {
            Map<Integer, Map<Integer, int[]>> filteredGraph = new HashMap<>();
            for (int k : graph.keySet()) {
                filteredGraph.put(k, new HashMap<>());
                for (int k1 : graph.get(k).keySet()) {
                    if (graph.get(k).get(k1)[1] >= currentWeight) {
                        filteredGraph.get(k).put(k1, graph.get(k).get(k1));
                    }
                }
            }

            Map<Integer, Integer> result = dijkstra(filteredGraph, 1, currentWeight);
            if (result.get(N) <= 1440) {
                System.out.println((currentWeight - maxWeight) / 100);
                return;
            }
        }

        System.out.println(0);
    }
}


