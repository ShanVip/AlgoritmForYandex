package com.DequeWithoutError;

import java.io.*;
import java.util.ArrayDeque;


public class Main{

    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<String>();
        File file = new File("input.txt");
        try {


            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()).strip() != null) {
//                    System.out.println(line);


                    if (line.equals("exit")) {
                        System.out.println("bye");
                        break;
                    }

                if (line.equals("size")) {
                    System.out.println(deque.size());
                }

                if (line.equals("clear")) {
                    deque.clear();
                    System.out.println("ok");
                }

                if (line.equals("front")) {
                    if (deque.size() > 0) {
                        System.out.println(deque.getFirst());
                    } else {
                        System.out.println("Error");
                    }
                }

                if (line.equals("back")) {
                    if (deque.size() > 0) {
                        System.out.println(deque.getLast());
                    } else {
                        System.out.println("Error");
                    }
                }

                if (line.equals("pop_front")) {
                    if (deque.size() > 0) {
                        System.out.println(deque.pollFirst());
                    } else {
                        System.out.println("Error");
                    }
                }

                if (line.equals("pop_back")) {
                    if (deque.size() > 0) {
                        System.out.println(deque.pollLast());
                    } else {
                        System.out.println("Error");
                    }
                }

                if (line.startsWith("push_front")) {
                        line = line.replace("push_front ", "");
                        deque.addFirst(line);
                        System.out.println("ok");
                }

                    if (line.startsWith("push_back")) {
                        line = line.replace("push_back ", "");
                        deque.addLast(line);
                        System.out.println("ok");
                    }


                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
