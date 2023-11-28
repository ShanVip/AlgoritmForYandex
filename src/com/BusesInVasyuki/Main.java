package com.BusesInVasyuki;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(reader.readLine());
        String[] dv = reader.readLine().split(" ");
        int d = Integer.parseInt(dv[0]);
        int v = Integer.parseInt(dv[1]);
        int R = Integer.parseInt(reader.readLine());

        List<List<int[]>> buses = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            buses.add(new ArrayList<>());
        }

        for (int i = 0; i < R; i++) {
            String[] line = reader.readLine().split(" ");
            int from = Integer.parseInt(line[0]) - 1;
            int departureTime = Integer.parseInt(line[1]);
            int to = Integer.parseInt(line[2]) - 1;
            int arrivalTime = Integer.parseInt(line[3]);
            buses.get(from).add(new int[]{to, departureTime, arrivalTime});
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[d - 1] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(u -> dist[u]));
        queue.add(d - 1);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int[] bus : buses.get(u)) {
                int v1 = bus[0];
                int t1 = bus[1];
                int t2 = bus[2];

                if (dist[v1] > t2) {
                    queue.remove(v1);
                    dist[v1] = t2;
                    queue.add(v1);
                } else if (dist[v1] < t1) {
                    queue.remove(v1);
                    dist[v1] = t1;
                    queue.add(v1);
                }
            }
        }

        if (dist[v - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[v - 1]);
        }

        reader.close();
    }
}

