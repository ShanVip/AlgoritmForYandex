package com.PostfixLine;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine().replaceAll(" ","");
        char[] chr = str1.toCharArray();


        Stack<Integer> stack = new Stack<>();

        int ans = 0;
        for (char c : chr){
            if (c == '-' || c == '+' || c == '*' || c == '/'){
                int first = stack.pop();
                int second = stack.pop();
                //System.out.println(stack);

                if (c == '-'){
                    ans = stack.push(second-first);
                }
                if (c == '+'){
                    ans = stack.push(second+first);
                }
                if (c == '*'){
                    ans = stack.push(second*first);
                }
                if (c == '/'){
                    ans = stack.push(second/first);
                }
            }else{
                stack.push(Character.getNumericValue(c));
            }
        }
        System.out.println(ans);
    }
}
