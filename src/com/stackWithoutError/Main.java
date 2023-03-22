package com.stackWithoutError;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        File file = new File("input.txt");
        try {


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
//                    System.out.println(line);


                if (line.equals("exit")) {
                    System.out.println("bye");
                    break;
                }

                if (line.equals("size")) {
                    System.out.println(stack.size());
                }

                if (line.equals("clear")) {
                    stack.clear();
                    System.out.println("ok");
                }

                if (line.equals("back")) {
                    if (stack.size() > 0) {
                        System.out.println(stack.peek());
                    } else {
                        System.out.println("Error");
                    }
                }

                if (line.equals("pop")) {
                    if (stack.size() > 0) {
                        System.out.println(stack.pop());
                    } else {
                        System.out.println("Error");
                    }
                }

                if (line.startsWith("push")) {
                    line = line.replace("push ", "");
                    stack.push(line);
                    System.out.println("ok");
                }


            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}



