package com.AllPermutationsOfGivenLength;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            int n = Integer.parseInt(reader.readLine());
            reader.close();

            List<Integer> a = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                a.add(i);
            }

            perm(new ArrayList<>(), a);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void perm(List<Integer> a, List<Integer> left) {
        if (left.isEmpty()) {
            System.out.println(String.join("", a.stream().map(String::valueOf).toArray(String[]::new)));
        } else {
            for (int i = 0; i < left.size(); i++) {
                List<Integer> newA = new ArrayList<>(a);
                newA.add(left.get(i));
                List<Integer> newLeft = new ArrayList<>(left.subList(0, i));
                newLeft.addAll(left.subList(i + 1, left.size()));
                perm(newA, newLeft);
            }
        }
    }
}
