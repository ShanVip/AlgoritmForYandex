package com.heap;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<String>();
        File file = new File("input.txt");
        try {

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine())!= null) {

                    if (line.startsWith("0")) {
                        line = line.replace("0 ", "");
                        if(!deque.isEmpty() && Integer.parseInt(line) < Integer.valueOf(deque.getLast())){
                            deque.addLast(line);
                            System.out.println(deque);
                            continue;
                        }else {
                            deque.addLast(line);
                            continue;
                        }
                    }


                    if (line.startsWith("1")){
                        if (!deque.isEmpty()){
                            System.out.println(deque.getLast());
                            deque.pollLast();

                        }
                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}