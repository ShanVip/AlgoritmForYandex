package com.train;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String str2 = scanner.nextLine();

        int[] trains = Arrays.stream(str2.split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] sorted_values = Arrays.copyOf(trains, trains.length);
        Arrays.sort(sorted_values);



        Stack<Integer> stack = new Stack<>();

        int current = 0;

        for (int num:trains){
            if (num == sorted_values[current]){
                current+=1;

                while (!stack.empty()){
                    int prev_num = stack.peek();

                    if(prev_num==sorted_values[current]){
                        stack.pop();
                        current+=1;
                    }
                    else break;
                    }

                }
            else{
                stack.push(num);
            }
        }

        if (stack.size()>0){
            System.out.println("NO");

        }
        else System.out.println("YES");
    }
}
