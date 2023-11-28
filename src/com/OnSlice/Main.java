package com.OnSlice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class Pair implements Comparable<Pair> {
        double vertex, distance;
        List<Double> path;

        public Pair(double vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
            this.path = new ArrayList<>();
        }

        public Pair(double distance, List<Double> path) {
            this.distance = distance;
            this.path = path;
        }

        @Override
        public int compareTo(Pair other) {
            return Double.compare(this.distance, other.distance);
        }
    }

    public static double[] dijkstraDist(double[][] graph, int startVertex) {
        int N = graph.length;
        boolean[] visited = new boolean[N];
        double[] distance = new double[N];
        int[] parent = new int[N];
        Arrays.fill(distance, Double.MAX_VALUE);
        Arrays.fill(parent, -1);
        distance[startVertex - 1] = 0;

        for (int count = 0; count < N; count++) {
            double minDistance = Double.MAX_VALUE;
            int current = -1;

            for (int v = 0; v < N; v++) {
                if (!visited[v] && distance[v] < minDistance) {
                    minDistance = distance[v];
                    current = v;
                }
            }

            if (minDistance == Double.MAX_VALUE) {
                break;
            }

            visited[current] = true;

            for (int v = 0; v < N; v++) {
                if (graph[current][v] > 0 && !visited[v]) {
                    double newDistance = distance[current] + graph[current][v];
                    if (newDistance < distance[v]) {
                        distance[v] = newDistance;
                        parent[v] = current;
                    }
                }
            }
        }

        return distance;
    }

    public static Pair dijkstra(double[][] graph, int start, int end, boolean findPath) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(start, 0));

        int N = graph.length;
        double[] distances = new double[N];
        Arrays.fill(distances, Double.MAX_VALUE);
        distances[start - 1] = 0;

        List<Double> parent = new ArrayList<>(Collections.nCopies(N, -1.0));

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            double currentDistance = currentPair.distance;
            int currentVertex = (int) currentPair.vertex;

            if (currentVertex == end) {
                if (findPath) {
                    List<Double> path = new ArrayList<>();
                    int current = end - 1;
                    while (current != -1) {
                        path.add((double) (current + 1));
                        current = parent.get(current).intValue();
                    }
                    Collections.reverse(path);
                    currentPair.path = path;
                    return currentPair;
                } else {
                    return currentPair;
                }
            }

            for (int v = 0; v < N; v++) {
                if (graph[currentVertex - 1][v] > 0) {
                    int neighbor = v + 1;
                    double weight = graph[currentVertex - 1][v];
                    double distance = currentDistance + weight;

                    if (distance < distances[neighbor - 1]) {
                        distances[neighbor - 1] = distance;
                        queue.add(new Pair((double) neighbor, distance));
                        if (findPath) {
                            parent.set(neighbor - 1, (double) currentVertex - 1);
                        }
                    }
                }
            }
        }

        return new Pair(-1, -1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(reader.readLine());

        List<double[]> drivers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            drivers.add(Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray());
        }

        double[][] graph = new double[N][N + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], -28.0);
        }

        while (true) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }

            String[] values = line.split(" ");
            int ai = Integer.parseInt(values[0]);
            int bi = Integer.parseInt(values[1]);
            double li = Double.parseDouble(values[2]);
            graph[ai - 1][bi - 1] = li;
            graph[bi - 1][ai - 1] = li;
        }

        double[][] shortestTime = new double[N][N];

        for (int i = 1; i <= N; i++) {
            double[] res = dijkstraDist(graph, i);
            for (int j = 1; j <= N; j++) {
                double[] driver = drivers.get(j - 1);
                shortestTime[j - 1][i - 1] = driver[0] + res[j - 1] / driver[1];
                driver = drivers.get(i - 1);
                shortestTime[i - 1][j - 1] = driver[0] + res[j - 1] / driver[1];
            }
        }

        double[][] newGraph = new double[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                int ai = i;
                int bi = j;
                double li = shortestTime[i][j];
                newGraph[ai][bi] = li;
            }
        }

        Pair ans = new Pair(0, List.of(1.0));

        for (int i = 2; i <= N; i++) {
            Pair res = dijkstra(newGraph, i, 1, true);
            if (res.distance > ans.distance) {
                ans = res;
            }
        }

        System.out.printf("%.10f\n", ans.distance);
        String pathString = ans.path.stream()
                .map(num -> String.valueOf(num.intValue())) // Преобразование в целое число и затем в строку
                .collect(Collectors.joining(" "));

        String result = pathString.replaceAll("\\.0", "");
        System.out.println(result);
    }
}
