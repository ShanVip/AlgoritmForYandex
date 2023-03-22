package com.queryWithoutError;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
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
                        System.out.println(queue.size());
                    }

                    if (line.equals("clear")) {
                       queue.clear();
                        System.out.println("ok");
                    }

                    if (line.equals("front")) {
                        if (queue.size() > 0) {
                            System.out.println(queue.peek());
                        } else {
                            System.out.println("Error");
                        }
                    }

                    if (line.equals("pop")) {
                        if (queue.size() > 0) {
                            System.out.println(queue.poll());
                        } else {
                            System.out.println("Error");
                        }
                    }

                    if (line.startsWith("push")) {
                        line = line.replace("push ", "");
                        queue.offer(line);
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



