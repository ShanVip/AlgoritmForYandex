package com.Layland;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String str = scanner.nextLine();

        int[] array = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<String> stack = new Stack<>();

        int[] answer = new int[array.length];
        Arrays.fill(answer, -1);

        int[] prev = new int[]{};

        for (int i = 0; i < array.length; i++) {
            while (!stack.empty() && array[Integer.parseInt(stack.peek())] > array[i] ){
                    answer[Integer.parseInt(stack.peek())]=i;
                    stack.pop();
            }
            stack.push(String.valueOf(i));
        }

        String str2 = Arrays.toString(answer).replaceAll("\\[|]", "").replace(",", "" );
        System.out.println(str2);

    }
}
