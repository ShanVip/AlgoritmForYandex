package com.drinkerGame;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        int[] num1 = Arrays.stream(str1.split(" ")).mapToInt(Integer::parseInt).toArray();
        String str2 = scanner.nextLine();
        int[] num2 = Arrays.stream(str2.split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> firstPlayer = new ArrayDeque<Integer>();
        ArrayDeque<Integer> secondPlayer = new ArrayDeque<Integer>();
        for (int j : num1) {
            firstPlayer.add(j);
        }
        for (int i : num2) {
            secondPlayer.add(i);
        }


        int moveCount = 0;

        while (firstPlayer.size() > 0 && secondPlayer.size() > 0) {
            if (moveCount >= Math.pow(10, 6)) {
                break;
            }
            int first = firstPlayer.pollFirst();
            int second = secondPlayer.pollFirst();

            if (first > second) {
                if (second == 0 && first == 9) {
                    secondPlayer.add(first);
                    secondPlayer.add(second);
                } else {
                    firstPlayer.add(first);
                    firstPlayer.add(second);
                }
            } else {
                if (first == 0 && second == 9) {
                    firstPlayer.add(first);
                    firstPlayer.add(second);
                } else {
                    secondPlayer.add(first);
                    secondPlayer.add(second);
                }
            }
            moveCount += 1;
        }
        if (firstPlayer.size() > 0 && secondPlayer.size() > 0) {
            System.out.println("botva");
        }
        if (firstPlayer.size() > 0) {
            System.out.println("first" + " " + moveCount);
        } else {
            System.out.println("second" + " " + moveCount);
        }

    }
}


