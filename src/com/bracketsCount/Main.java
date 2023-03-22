package com.bracketsCount;


import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        char[] chr = str1.toCharArray();

        if(chr.length==0){
            System.out.println("no");
            return;
        }

        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        for (int i = 0; i < chr.length; i++) {
            if (chr[i] == '(' || chr[i] == '[' || chr[i] == '{') {
                stack.push(chr[i]);
            } else if (stack.empty()) {
                answer = false;
                break;
            } else if (stack.peek() == '{') {
                if (chr[i] == '}')
                    stack.pop();
                else {
                    answer = false;
                    break;
                }
            } else if (stack.peek() == '(') {
                if (chr[i] == ')')
                    stack.pop();
                else {
                    answer = false;
                    break;
                }
            } else if (stack.peek() == '[') {
                if (chr[i] == ']')
                    stack.pop();
                else {
                    answer = false;
                    break;
                }
            }


        }
        if (answer && stack.empty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }


    }
}

